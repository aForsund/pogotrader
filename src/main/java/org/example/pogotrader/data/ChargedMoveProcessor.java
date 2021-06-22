package org.example.pogotrader.data;

import org.example.pogotrader.model.ChargedMove;
import org.example.pogotrader.model.Effect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.item.ItemProcessor;
import javax.transaction.Transactional;

@Transactional
public class ChargedMoveProcessor implements ItemProcessor<ChargedMoveInput, ChargedMove> {

  @Autowired
  private TypeService typeService;

  @Autowired
  private RegexService regexService;

  @Override
  public ChargedMove process(final ChargedMoveInput chargedMoveInput) throws Exception {

    System.out.println("Hello from ChargedMoveProcessor");

    ChargedMove chargedMove = new ChargedMove(chargedMoveInput.getName(),
        typeService.findByName(chargedMoveInput.getType()));

    chargedMove.setPower(Integer.parseInt(chargedMoveInput.getPower()));
    chargedMove.setDamageWindow(Double.parseDouble(chargedMoveInput.getDamageWindow()));
    chargedMove.setCooldown(Double.parseDouble(chargedMoveInput.getCooldown()));
    chargedMove.setBars(Integer.parseInt(chargedMoveInput.getBars()));
    chargedMove.setDamage(Integer.parseInt(chargedMoveInput.getDamage()));
    chargedMove.setEnergy(Integer.parseInt(chargedMoveInput.getEnergy()));

    // Check if charged move has any effects
    if (!(chargedMoveInput.getEffect().isEmpty())) {

      Effect effect = new Effect();
      effect.setChance((double) regexService.getPercent(chargedMoveInput.getEffect()) / 100);
      System.out.println("Effect chance " + effect.getChance());

      chargedMove.setEffect(effect);

    }

    return chargedMove;
  }

}
