package org.example.pogotrader.repository;

import java.util.HashSet;
import org.example.pogotrader.model.ChargedMove;
import org.springframework.data.repository.CrudRepository;

public interface ChargedMoveRepository extends CrudRepository<ChargedMove, Integer> {

  HashSet<ChargedMove> findByName(String name);

  HashSet<ChargedMove> findByType(String type);

  HashSet<ChargedMove> findAll();

}
