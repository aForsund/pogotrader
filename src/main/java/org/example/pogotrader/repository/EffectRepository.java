package org.example.pogotrader.repository;

import org.springframework.data.repository.CrudRepository;
import org.example.pogotrader.model.Effect;
import java.util.HashSet;

public interface EffectRepository extends CrudRepository<Effect, Integer> {

  Effect findById(int id);

  HashSet<Effect> findAll();

}
