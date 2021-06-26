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

  @Autowired
  private EffectService effectService;

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
      effect.setModifier(regexService.getModifier(chargedMoveInput.getEffect()));

      if (regexService.getSelf(chargedMoveInput.getEffect())) {
        effect.setSelfAttack(regexService.getAttack(chargedMoveInput.getEffect()));
        effect.setSelfDefense(regexService.getDefense(chargedMoveInput.getEffect()));
      } else if (regexService.getOpponent(chargedMoveInput.getEffect())) {
        effect.setOpponentAttack(regexService.getAttack(chargedMoveInput.getEffect()));
        effect.setOpponentDefense(regexService.getDefense(chargedMoveInput.getEffect()));
      }

      chargedMove.setEffect(effect);
      effectService.save(effect);

    }

    typeService.findByName(chargedMoveInput.getType()).addChargedMove(chargedMove);
    typeService.save(typeService.findByName(chargedMoveInput.getType()));

    return chargedMove;
  }

}
