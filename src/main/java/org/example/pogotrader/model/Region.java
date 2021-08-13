package org.example.pogotrader.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Region {

  @Id
  private int id;
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
  private Set<PokedexEntry> regionEntries = new HashSet<>();

  public Region() {
  }

  public void setId(int number) {
    this.id = number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }

  public void addRegionEntry(PokedexEntry entry) {
    this.regionEntries.add(entry);
  }

  public Set<PokedexEntry> getRegionEntries() {
    return this.regionEntries;
  }

  @Override
  public String toString() {
    return this.getName();
  }

  @Override
  public int hashCode() {

    int hashCode;
    try {
      hashCode = Integer.parseInt(this.name) + this.id;

    } catch (NumberFormatException e) {
      hashCode = 0;
    }

    return hashCode;
  }

  @Override
  public boolean equals(Object compared) {
    if (this == compared) {
      return true;
    }

    if (!(compared instanceof Region)) {
      return false;
    }

    Region comparedRegion = (Region) compared;
    if (comparedRegion.getId() == this.getId()) {
      return true;
    }
    return false;
  }

}
