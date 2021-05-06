package org.example.pogotrader.repository;

import java.util.ArrayList;

import org.example.pogotrader.model.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Integer> {

  Type findByName(String name);

  Type findById(int id);

  ArrayList<Type> findAll();

}
