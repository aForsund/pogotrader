package org.example.pogotrader.data;

import org.example.pogotrader.model.Effect;
import org.example.pogotrader.repository.EffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EffectService {

  @Autowired
  private EffectRepository effectRepository;

  public EffectService(EffectRepository effectRepository) {
    this.effectRepository = effectRepository;
  }

  public void save(Effect effect) {
    effectRepository.save(effect);
  }
}
