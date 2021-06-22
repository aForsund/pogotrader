package org.example.pogotrader.data;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegexConfig {

  @Bean
  public Pattern percentPattern() {
    return Pattern.compile("(\\d+)(?:%|\\s%)");
  }
}
