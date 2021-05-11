package org.example.pogotrader.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import java.util.HashSet;

@Entity
public class MoveSet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany
  @JoinTable(name = "moves")
  private Set<Move> moves = new HashSet<>();

  @OneToMany
  @JoinTable(name = "legacy_moves")
  private Set<Move> legacyMoves = new HashSet<>();

  @OneToMany
  @JoinTable(name = "elite_moves")
  private Set<Move> eliteMoves = new HashSet<>();

  public MoveSet() {
  }

  public Long getId() {
    return this.id;
  }

  public void addMove(Move move) {
    this.moves.add(move);
  }

  public void addLegacyMove(Move move) {
    this.legacyMoves.add(move);
  }

  public void addEliteMove(Move move) {
    this.eliteMoves.add(move);
  }

  public Set<Move> getMoves() {
    return this.moves;
  }

  public Set<Move> getLegacyMoves() {
    return this.legacyMoves;
  }

  public Set<Move> getEliteMoves() {
    return this.eliteMoves;
  }
}
