package org.example.pogotrader.model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Type {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String properties;

  @OneToMany
  @JoinTable(name = "weak_to", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
      @JoinColumn(name = "name") })
  private List<Type> weakTo = new ArrayList<>();
  // private HashSet<Type> resistantTo;
  // private HashSet<Type> immuneTo;

  public Type() {

  }

  public Type(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setProperties(String properties) {
    this.properties = properties;
  }

  public String getProperties() {
    return this.properties;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return this.name + " - Weak against: " + this.weakTo;
  }

  /*
   * public void setWeakness(HashSet<Type> typeSet) { this.weakAgainst = typeSet;
   * }
   */
  public void addWeakTo(Type type) {
    this.weakTo.add(type);
  }

  public List<Type> getWeakTo() {
    return this.weakTo;
  }

  // public HashSet<Type> resistantTo() { return this.resistantTo; }

  // public HashSet<Type> immuneTo() { return this.immuneTo; }

  @Override
  public boolean equals(Object compared) {
    return false;
  }

}
