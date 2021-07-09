package org.example.pogotrader.repository;

import java.util.HashSet;
import org.example.pogotrader.model.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {

  Region findByNameIgnoreCase(String name);

  Region findById(int id);

  HashSet<Region> findAll();

}
