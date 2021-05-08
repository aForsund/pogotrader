package org.example.pogotrader.model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Type {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String properties;

  @ManyToOne
  private Type parent;

  @OneToMany(mapped by="parent")
  @JoinTable(name = "weak_to", joinColumns = { @JoinColumn(name = "name") }, inverseJoinColumns = {
      @JoinColumn(name = "weakTo") })
  private Set<Type> weakTo = new HashSet<>();
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
    return this.name;
  }

  /*
   * public void setWeakness(HashSet<Type> typeSet) { this.weakAgainst = typeSet;
   * }
   */
  public void addWeakTo(Set<Type> listOfTypes) {
    this.weakTo = listOfTypes;
  }

  public Set<Type> getWeakTo() {
    return this.weakTo;
  }

  // public HashSet<Type> resistantTo() { return this.resistantTo; }

  // public HashSet<Type> immuneTo() { return this.immuneTo; }

  @Override
  public boolean equals(Object compared) {
    return false;
  }

}
