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

  @Bean
  public Pattern selfPattern() {
    return Pattern.compile("(?:self)", Pattern.CASE_INSENSITIVE);
  }

  @Bean
  public Pattern opponentPattern() {
    return Pattern.compile("(?:opponent)", Pattern.CASE_INSENSITIVE);
  }

  @Bean
  public Pattern positiveModifierPattern() {
    return Pattern.compile("(?:\\+)(\\d+)\s(?:atk|def)", Pattern.CASE_INSENSITIVE);
  }

  @Bean
  public Pattern negativeModifierPattern() {
    return Pattern.compile("(?:\\-)(\\d+)\s(?:atk|def)", Pattern.CASE_INSENSITIVE);
  }

  @Bean
  public Pattern attackPattern() {
    return Pattern.compile("(?:atk)", Pattern.CASE_INSENSITIVE);
  }

  @Bean
  public Pattern defensePattern() {
    return Pattern.compile("(?:def)", Pattern.CASE_INSENSITIVE);
  }
}
