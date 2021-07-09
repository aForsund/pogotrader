package org.example.pogotrader.data;

import java.util.Set;
import org.example.pogotrader.model.Region;
import org.example.pogotrader.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

  @Autowired
  private RegionRepository regionRepository;

  public RegionService(RegionRepository regionRepository) {
    this.regionRepository = regionRepository;
  }

  public Region findById(int id) {
    return regionRepository.findById(id);
  }

  public Region findByName(String name) {
    return regionRepository.findByNameIgnoreCase(name);
  }

  public Set<Region> list() {
    return regionRepository.findAll();
  }

  public void save(Region region) {
    regionRepository.save(region);
  }
}
