package org.example.pogotrader.data;

import java.sql.ResultSet;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      jdbcTemplate
          .query("SELECT number, name, id FROM pokedex_entry",
              (rs, row) -> new PokedexEntry(rs.getInt(3), rs.getInt(1), rs.getString(2)))
          .forEach(pokemon -> System.out.println(pokemon));

      jdbcTemplate.query("SELECT name FROM type", (rs, row) -> new Type(rs.getString(1)))
          .forEach(type -> System.out.println(type + " weak to: " + type.getWeakTo().toString()));

    }
    try {
      showTables();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Autowired
  protected DataSource dataSource;

  public void showTables() throws Exception {
    DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
    ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });
    while (tables.next()) {
      String tableName = tables.getString("TABLE_NAME");
      System.out.println(tableName);
      ResultSet columns = metaData.getColumns(null, null, tableName, "%");
      while (columns.next()) {
        String columnName = columns.getString("COLUMN_NAME");
        System.out.println("\t" + columnName);
      }
    }
  }
}
