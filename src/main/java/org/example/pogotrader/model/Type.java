package org.example.pogotrader.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Type {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @JsonIgnoreProperties({ "weakTo" })
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "weak_to")
  private Set<Type> weakTo = new HashSet<>();

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

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "Type: " + this.name;
  }

  public void setWeakTo(Set<Type> listOfTypes) {
    this.weakTo = listOfTypes;
  }

  public Set<Type> getWeakTo() {
    return this.weakTo;
  }

  // public HashSet<Type> resistantTo() { return this.resistantTo; }

  // public HashSet<Type> immuneTo() { return this.immuneTo; }

  @Override
  public boolean equals(Object compared) {
    if (this == compared) {
      return true;
    }

    if (!(compared instanceof Type)) {
      return false;
    }

    Type comparedType = (Type) compared;
    if (comparedType.getName().equals(this.name)) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hashCode;
    try {
      hashCode = Integer.parseInt(this.name);

    } catch (NumberFormatException e) {
      hashCode = 0;
    }
    return hashCode;

  }

}
