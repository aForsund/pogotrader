package org.example.pogotrader.data;

import org.example.pogotrader.model.Type;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

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
    System.out.println("printing Type:");
    System.out.println(type);
    System.out.println(type.getId());
    FastMove fastMove = new FastMove(fastMoveInput.getName(), typeService.findByName(fastMoveInput.getType()));

    fastMove.setRaidPower(Integer.parseInt(fastMoveInput.getRaidPower()));
    fastMove.setCooldown(Double.parseDouble(fastMoveInput.getCooldown()));
    fastMove.setRaidEnergy(Integer.parseInt(fastMoveInput.getRaidEnergy()));
    fastMove.setPower(Integer.parseInt(fastMoveInput.getPower()));
    fastMove.setEnergy(Integer.parseInt(fastMoveInput.getEnergy()));
    fastMove.setTurns(Integer.parseInt(fastMoveInput.getTurns()));

    typeService.findByName(fastMoveInput.getType()).addFastMove(fastMove);
    typeService.save(typeService.findByName(fastMoveInput.getType()));

    return fastMove;
  }

}
