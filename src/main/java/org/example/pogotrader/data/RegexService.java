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

}
