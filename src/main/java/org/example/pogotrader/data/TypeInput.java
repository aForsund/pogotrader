package org.example.pogotrader.data;

public class TypeInput {

  private String name;
  private String weakTo;
  private String resistantTo;
  private String immuneTo;

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

  public void setResistantTo(String values) {
    this.resistantTo = values;
  }

  public String getResistantTo() {
    return this.resistantTo;
  }

  public void setImmuneTo(String values) {
    this.immuneTo = values;
  }

  public String getImmuneTo() {
    return this.immuneTo;
  }

}
