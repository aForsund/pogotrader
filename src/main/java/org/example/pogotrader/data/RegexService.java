package org.example.pogotrader.data;

import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RegexService {

  @Autowired
  RegexConfig regexConfig;

  public int getPercent(String testString) {
    Matcher m = regexConfig.percentPattern().matcher(testString);

    return m.find() ? Integer.parseInt(m.group(1)) : -1;
  }

  public boolean getSelf(String testString) {
    Matcher m = regexConfig.selfPattern().matcher(testString);

    return m.find();
  }

  public boolean getOpponent(String testString) {
    Matcher m = regexConfig.opponentPattern().matcher(testString);

    return m.find();
  }

  public int getModifier(String testString) {
    Matcher m = regexConfig.positiveModifierPattern().matcher(testString);

    if (m.find()) {
      return Integer.parseInt(m.group(1));
    }

    m = regexConfig.negativeModifierPattern().matcher(testString);

    return m.find() ? Integer.parseInt(m.group(1)) * -1 : 0;

  }

  public boolean getAttack(String testString) {
    Matcher m = regexConfig.attackPattern().matcher(testString);

    return m.find();
  }

  public boolean getDefense(String testString) {
    Matcher m = regexConfig.defensePattern().matcher(testString);

    return m.find();
  }

}
