package org.example.pogotrader.repository;

import java.util.HashSet;

import org.example.pogotrader.model.FastMove;
import org.springframework.data.repository.CrudRepository;

public interface FastMoveRepository extends CrudRepository<FastMove, Integer> {

  FastMove findByName(String name);

  FastMove findByType(String type);

  HashSet<FastMove> findAll();

}
