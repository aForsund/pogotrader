package org.example.pogotrader.data;

import org.springframework.batch.item.ItemProcessor;
import org.example.pogotrader.model.PokedexEntry;

public class PokedexProcessor implements ItemProcessor<PokedexInput, PokedexEntry> {

  @Override
  public PokedexEntry process(final PokedexInput pokedexInput) throws Exception {

    PokedexEntry pokemon = new PokedexEntry();
    pokemon.setId(Integer.parseInt(pokedexInput.getId()));
    pokemon.setName(pokedexInput.getName());
    pokemon.setNumber(Integer.valueOf(pokedexInput.getNumber()));
    pokemon.setCode(Integer.parseInt(pokedexInput.getCode()));
    // pokemon.setNextEvolution(Integer.parseInt(pokedexInput.getNext_evolution()));
    // pokemon.setPrevEvolution(Integer.parseInt(pokedexInput.getPrev_evolution()));
    // pokemon.setTypeOne(pokedexInput.getType_one());
    // pokemon.setTypeTwo(pokedexInput.getType_two());
    pokemon.setColor(pokedexInput.getColor());
    pokemon.setAttack(Integer.parseInt(pokedexInput.getAttack()));
    pokemon.setDefense(Integer.parseInt(pokedexInput.getDefense()));
    pokemon.setHealth(Integer.parseInt(pokedexInput.getHealth()));
    pokemon.setCombatPower(Integer.parseInt(pokedexInput.getCombat_power()));
    // pokemon.setRegion(Integer.parseInt(pokedexInput.getRegion()));
    pokemon.setLegendary(Integer.parseInt(pokedexInput.getLegendary()) == 1);
    pokemon.setMythical(Integer.parseInt(pokedexInput.getMythical()) == 1);
    pokemon.setMega(Integer.parseInt(pokedexInput.getMega()) == 1);
    pokemon.setShadow(Integer.parseInt(pokedexInput.getShadow()) == 1);
    pokemon.setShiny(Integer.parseInt(pokedexInput.getShiny()) == 1);
    pokemon.setHeight(Double.parseDouble(pokedexInput.getHeight()));
    pokemon.setWeight(Double.parseDouble(pokedexInput.getWeight()));

    return pokemon;
  }

}
