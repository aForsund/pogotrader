package org.example.pogotrader.repository;

import java.util.HashSet;

import org.example.pogotrader.model.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Integer> {

  Type findByName(String name);

  HashSet<Type> findAll();

  // HashSet<Type> findByNameGetWeakTo(String name);

  // HashSet<Type> findWeakTo(String name);

  boolean existsByName(String name);

}
