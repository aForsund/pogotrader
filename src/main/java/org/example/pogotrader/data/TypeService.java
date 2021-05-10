package org.example.pogotrader.data;

import java.util.Set;

import org.example.pogotrader.model.Type;

import org.example.pogotrader.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

  @Autowired
  private TypeRepository typeRepository;

  public TypeService(TypeRepository typeRepository) {
    this.typeRepository = typeRepository;
  }

  public Type findByName(String name) {
    return typeRepository.findByName(name);
  }

  public Set<Type> list() {
    return typeRepository.findAll();
  }

  public boolean exists(String name) {
    return typeRepository.existsByName(name);
  }

  public void save(Type type) {
    typeRepository.save(type);
  }

}
