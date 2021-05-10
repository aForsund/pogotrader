package org.example.pogotrader.data;

import javax.sql.DataSource;

import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

  private final String[] FIELD_NAMES = new String[] { "number", "code", "id", "next_evolution", "prev_evolution",
      "name", "type_one", "type_two", "color", "attack", "defense", "health", "combat_power", "region", "legendary",
      "mythical", "mega", "shadow", "shiny", "height", "weight" };

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public FlatFileItemReader<PokedexInput> pokedexReader() {
    return new FlatFileItemReaderBuilder<PokedexInput>().name("PokemonItemReader")
        .resource(new ClassPathResource("test3.csv")).delimited().names(FIELD_NAMES)
        .fieldSetMapper(new BeanWrapperFieldSetMapper<PokedexInput>() {
          {
            setTargetType(PokedexInput.class);
            setDistanceLimit(2);
          }
        }).build();
  }

  @Bean
  public FlatFileItemReader<TypeInput> typeReader() {
    return new FlatFileItemReaderBuilder<TypeInput>().name("TypeItemReader")
        .resource(new ClassPathResource("types.csv")).delimited().names(new String[] { "name" })
        .fieldSetMapper(new BeanWrapperFieldSetMapper<TypeInput>() {
          {
            setTargetType(TypeInput.class);
            setDistanceLimit(2);
          }
        }).build();
  }

  @Bean
  public FlatFileItemReader<TypeInput> typePropertiesReader() {
    return new FlatFileItemReaderBuilder<TypeInput>().name("TypeItemReader")
        .resource(new ClassPathResource("typeProperties.csv")).delimited()
        .names(new String[] { "name", "weak_to", "resistant_to", "immune_to" })
        .fieldSetMapper(new BeanWrapperFieldSetMapper<TypeInput>() {
          {
            setTargetType(TypeInput.class);
            setDistanceLimit(2);
          }
        }).build();
  }

  @Bean
  public PokedexProcessor pokedexProcessor() {
    return new PokedexProcessor();
  }

  @Bean
  public TypeProcessor typeProcessor() {
    return new TypeProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<PokedexEntry> pokedexWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<PokedexEntry>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql(
            "INSERT INTO pokedex_entry (number, code, id, next_evolution, prev_evolution, name, type_one, type_two, color, attack, defense, health, combat_power, region, legendary, mythical, mega, shadow, shiny, height, weight) "
                + "VALUES (:number, :code, :id, :nextEvolution, :prevEvolution, :name, :typeOne, :typeTwo, :color, :attack, :defense, :health, :combatPower, :region, :legendary, :mythical, :mega, :shadow, :shiny, :height, :weight)")
        .dataSource(dataSource).build();

  }

  @Bean
  @Primary
  public JdbcBatchItemWriter<Type> typeWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Type>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("MERGE INTO type AS t" + " USING (" + " VALUES (:name) ) AS s (name)" + " ON t.name=s.name"
            + " WHEN MATCHED THEN" + " UPDATE SET t.name=s.name" + " WHEN NOT MATCHED THEN"
            + " INSERT (name) VALUES (:name)")
        .dataSource(dataSource).build();

  }

  /*
   * @Bean JdbcBatchItemWriter<Type> typePropertiesWriter(DataSource dataSource) {
   * return new JdbcBatchItemWriterBuilder<Type>()
   * .itemSqlParameterSourceProvider(new
   * BeanPropertyItemSqlParameterSourceProvider<>())
   * .sql("INSERT INTO type (weakTo) VALUES (:weakTo)").dataSource(dataSource).
   * build(); }
   */
  @Bean
  public Job readData(JobCompletionNotificationListener listener, Step importTypes, Step importTypeProperties,
      Step step1) {
    return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
        .start(importTypes).next(importTypeProperties).next(step1).build();
  }

  @Bean
  public Step importTypes(JdbcBatchItemWriter<Type> writer) {
    return stepBuilderFactory.get("importTypes").<TypeInput, Type>chunk(18).reader(typeReader())
        .processor(typeProcessor()).writer(writer).build();
  }

  @Bean
  public Step importTypeProperties(JdbcBatchItemWriter<Type> writer) {
    return stepBuilderFactory.get("importTypeProperties").<TypeInput, Type>chunk(18).reader(typePropertiesReader())
        .processor(typeProcessor()).writer(writer).build();
  }

  @Bean
  public Step step1(JdbcBatchItemWriter<PokedexEntry> writer) {
    return stepBuilderFactory.get("step1").<PokedexInput, PokedexEntry>chunk(10).reader(pokedexReader())
        .processor(pokedexProcessor()).writer(writer).build();
  }

}
