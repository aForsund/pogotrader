package org.example.pogotrader.data;

import java.util.ArrayList;
import org.example.pogotrader.model.Type;

import org.example.pogotrader.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

  @Autowired
  private TypeRepository typeRepository;

  public Type findByName(String name) {
    return typeRepository.findByName(name);
  }

  public ArrayList<Type> list() {
    return typeRepository.findAll();
  }
}
