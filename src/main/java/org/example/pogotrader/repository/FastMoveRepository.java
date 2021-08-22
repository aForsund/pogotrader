package org.example.pogotrader.repository;

import java.util.HashSet;

import org.example.pogotrader.model.FastMove;
import org.springframework.data.repository.CrudRepository;

public interface FastMoveRepository extends CrudRepository<FastMove, Integer> {

  HashSet<FastMove> findByName(String name);

  HashSet<FastMove> findByType(String type);

  HashSet<FastMove> findAll();

  FastMove findById(int id);

}
