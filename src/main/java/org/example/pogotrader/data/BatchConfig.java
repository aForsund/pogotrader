package org.example.pogotrader.data;

import javax.sql.DataSource;

import org.example.pogotrader.model.ChargedMove;
import org.example.pogotrader.model.FastMove;
import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.example.pogotrader.model.Region;

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

import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public FlatFileItemReader<PokedexInput> pokedexReader() {
    return new FlatFileItemReaderBuilder<PokedexInput>().name("PokemonItemReader")
        .resource(new ClassPathResource("pokedexEntries.csv")).delimited()
        .names(new String[] { "number", "id", "next_evolution", "prev_evolution", "name", "type_one", "type_two",
            "color", "attack", "defense", "health", "combat_power", "region", "legendary", "mythical", "mega", "shadow",
            "shiny", "height", "weight" })
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
  public FlatFileItemReader<FastMoveInput> fastMoveReader() {
    return new FlatFileItemReaderBuilder<FastMoveInput>().name("FastMoveReader")
        .resource(new ClassPathResource("fastMoves.csv")).delimited()
        .names(new String[] { "name", "type", "raid_power", "raid_energy", "cooldown", "power", "energy", "turns" })
        .fieldSetMapper(new BeanWrapperFieldSetMapper<FastMoveInput>() {
          {
            setTargetType(FastMoveInput.class);
            setDistanceLimit(1);
          }
        }).build();
  }

  @Bean
  public FlatFileItemReader<ChargedMoveInput> chargedMoveReader() {
    return new FlatFileItemReaderBuilder<ChargedMoveInput>().name("ChargedMoveReader")
        .resource(new ClassPathResource("chargedMoves.csv")).delimited()
        .names(
            new String[] { "name", "type", "bars", "cooldown", "damage_window", "power", "damage", "energy", "effect" })
        .fieldSetMapper(new BeanWrapperFieldSetMapper<ChargedMoveInput>() {
          {
            setTargetType(ChargedMoveInput.class);
            setDistanceLimit(1);
          }
        }).build();
  }

  @Bean
  public FlatFileItemReader<RegionInput> regionReader() {
    return new FlatFileItemReaderBuilder<RegionInput>().name("RegionReader")
        .resource(new ClassPathResource("regions.csv")).delimited().names(new String[] { "id", "name" })
        .fieldSetMapper(new BeanWrapperFieldSetMapper<RegionInput>() {
          {
            setTargetType(RegionInput.class);
            setDistanceLimit(1);
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
  public FastMoveProcessor fastMoveProcessor() {
    return new FastMoveProcessor();
  }

  @Bean
  public ChargedMoveProcessor chargedMoveProcessor() {
    return new ChargedMoveProcessor();
  }

  @Bean
  public RegionProcessor regionProcessor() {
    return new RegionProcessor();
  }

  @Bean
  public JdbcBatchItemWriter<PokedexEntry> pokedexWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<PokedexEntry>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("MERGE INTO pokedex_entry AS t" + " USING (" + " VALUES (:id, :number) ) AS s (id, number)"
            + " ON t.id=s.id" + " WHEN MATCHED THEN" + " UPDATE SET t.number = s.number" + " WHEN NOT MATCHED THEN"
            + " INSERT (number, id, name, color, attack, defense, health, combat_power, legendary, mythical, mega, shadow, shiny, height, weight) "
            + " VALUES (:number, :id, :name, :color, :attack, :defense, :health, :combatPower, :legendary, :mythical, :mega, :shadow, :shiny, :height, :weight) ")
        .dataSource(dataSource).build();

  }

  @Bean
  public JdbcBatchItemWriter<Type> typeWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Type>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("MERGE INTO type AS t" + " USING (" + " VALUES (:name) ) AS s (name)" + " ON t.name=s.name"
            + " WHEN MATCHED THEN" + " UPDATE SET t.name=s.name" + " WHEN NOT MATCHED THEN"
            + " INSERT (name) VALUES (:name)")
        .dataSource(dataSource).build();

  }

  @Bean
  public JdbcBatchItemWriter<FastMove> fastMoveWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<FastMove>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO fast_move (name, raid_power, raid_energy, cooldown, power, energy, turns) "
            + "VALUES (:name, :raidPower, :raidEnergy, :cooldown, :power, :energy, :turns)")
        .dataSource(dataSource).build();
  }

  @Bean
  public JdbcBatchItemWriter<ChargedMove> chargedMoveWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<ChargedMove>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO charged_move (name, bars, cooldown, damage_window, power, damage, energy) "
            + "VALUES (:name, :bars, :cooldown, :damageWindow, :power, :damage, :energy)")
        .dataSource(dataSource).build();
  }

  @Bean
  JdbcBatchItemWriter<Region> regionWriter(DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Region>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO region (id, name) VALUES (:id, :name)").dataSource(dataSource).build();
  }

  @Bean
  public Job readData(JobCompletionNotificationListener listener, Step importTypes, Step importTypeProperties,
      Step importFastMoves, Step importChargedMoves, Step importRegions, Step importPokedexEntries,
      Step importPokedexEntriesProperties) {
    return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
        .start(importTypes).next(importTypeProperties).next(importFastMoves).next(importChargedMoves)
        .next(importRegions).next(importPokedexEntries).next(importPokedexEntriesProperties).build();
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
  public Step importFastMoves(JdbcBatchItemWriter<FastMove> writer) {
    return stepBuilderFactory.get("importFastMoves").<FastMoveInput, FastMove>chunk(10).reader(fastMoveReader())
        .processor(fastMoveProcessor()).writer(writer).build();
  }

  @Bean
  public Step importChargedMoves(JdbcBatchItemWriter<ChargedMove> writer) {
    return stepBuilderFactory.get("importChargedMoves").<ChargedMoveInput, ChargedMove>chunk(10)
        .reader(chargedMoveReader()).processor(chargedMoveProcessor()).writer(writer).build();
  }

  @Bean
  public Step importRegions(JdbcBatchItemWriter<Region> writer) {
    return stepBuilderFactory.get("importRegions").<RegionInput, Region>chunk(10).reader(regionReader())
        .processor(regionProcessor()).writer(writer).build();
  }

  @Bean
  public Step importPokedexEntries(JdbcBatchItemWriter<PokedexEntry> writer) {
    return stepBuilderFactory.get("importPokedexEntries").<PokedexInput, PokedexEntry>chunk(1).reader(pokedexReader())
        .processor(pokedexProcessor()).writer(writer).build();
  }

  @Bean
  public Step importPokedexEntriesProperties(JdbcBatchItemWriter<PokedexEntry> writer) {
    return stepBuilderFactory.get("importPokedexEntriesProperties").<PokedexInput, PokedexEntry>chunk(1)
        .reader(pokedexReader()).processor(pokedexProcessor()).writer(writer).build();
  }

}
