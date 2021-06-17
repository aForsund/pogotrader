package org.example.pogotrader.data;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.pogotrader.model.Type;

import javax.transaction.Transactional;

import org.example.pogotrader.model.FastMove;

@Transactional
public class FastMoveProcessor implements ItemProcessor<FastMoveInput, FastMove> {

  @Autowired
  private TypeService typeService;

  @Override
  public FastMove process(final FastMoveInput fastMoveInput) throws Exception {

    System.out.println("Hello from FastMoveProcessor");
    System.out.println("I'm now accessing " + fastMoveInput.getName() + " of type " + fastMoveInput.getType());
    Type type = typeService.findByName(fastMoveInput.getType());
    FastMove fastMove = new FastMove();
    fastMove.setName(fastMoveInput.getName());
    fastMove.setType(type);
    fastMove.setPvePower(Integer.parseInt(fastMoveInput.getPvePower()));
    fastMove.setPveCooldown(Double.parseDouble(fastMoveInput.getPveCooldown()));
    fastMove.setPveEnergy(Integer.parseInt(fastMoveInput.getPveEnergy()));
    fastMove.setPvpDamage(Integer.parseInt(fastMoveInput.getPvpPower()));
    fastMove.setPvpEnergy(Integer.parseInt(fastMoveInput.getPvpEnergy()));
    fastMove.setPvpTurns(Integer.parseInt(fastMoveInput.getPvpTurns()));

    return fastMove;
  }

}
