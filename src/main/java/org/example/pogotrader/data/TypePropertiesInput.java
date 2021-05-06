package org.example.pogotrader.data;

public class TypePropertiesInput {

  private String name;
  private String weakTo;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWeakTo() {
    return this.weakTo;
  }

  public void setWeakTo(String dashSeparatedValues) {
    this.weakTo = dashSeparatedValues;
  }

}