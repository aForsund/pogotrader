package org.example.pogotrader.data;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.pogotrader.model.PokedexEntry;

public class PokedexProcessor implements ItemProcessor<PokedexInput, PokedexEntry> {

  @Autowired
  private TypeService typeService;

  @Autowired
  private RegionService regionService;

  // @Autowired
  // private PokedexService pokedexService;

  @Override
  public PokedexEntry process(final PokedexInput pokedexInput) throws Exception {

    PokedexEntry pokemon = new PokedexEntry();

    pokemon.setName(pokedexInput.getName());
    pokemon.setId(Integer.parseInt(pokedexInput.getId()));
    pokemon.setNumber(Integer.valueOf(pokedexInput.getNumber()));
    pokemon.setCode(Integer.parseInt(pokedexInput.getCode()));

    pokemon.setColor(pokedexInput.getColor());
    pokemon.setAttack(Integer.parseInt(pokedexInput.getAttack()));
    pokemon.setDefense(Integer.parseInt(pokedexInput.getDefense()));
    pokemon.setHealth(Integer.parseInt(pokedexInput.getHealth()));
    pokemon.setCombatPower(Integer.parseInt(pokedexInput.getCombatPower()));

    pokemon.setLegendary(Integer.parseInt(pokedexInput.getLegendary()) == 1);
    pokemon.setMythical(Integer.parseInt(pokedexInput.getMythical()) == 1);
    pokemon.setMega(Integer.parseInt(pokedexInput.getMega()) == 1);
    pokemon.setShadow(Integer.parseInt(pokedexInput.getShadow()) == 1);
    pokemon.setShiny(Integer.parseInt(pokedexInput.getShiny()) == 1);
    pokemon.setHeight(Double.parseDouble(pokedexInput.getHeight()));
    pokemon.setWeight(Double.parseDouble(pokedexInput.getWeight()));

    // Set & save region
    pokemon.setRegion(regionService.findById(Integer.parseInt(pokedexInput.getRegion())));
    regionService.save(regionService.findById(Integer.parseInt(pokedexInput.getRegion())));

    // Set & save type
    if (!(pokedexInput.getTypeOne().isEmpty())) {
      pokemon.addTyping(typeService.findByName(pokedexInput.getTypeOne()));
      typeService.findByName(pokedexInput.getTypeOne()).addPokedexEntry(pokemon);
      typeService.save(typeService.findByName(pokedexInput.getTypeOne()));

    }

    if (!(pokedexInput.getTypeTwo().isEmpty())) {
      pokemon.addTyping(typeService.findByName(pokedexInput.getTypeTwo()));
      typeService.findByName(pokedexInput.getTypeTwo()).addPokedexEntry(pokemon);
      typeService.save(typeService.findByName(pokedexInput.getTypeTwo()));
    }

    // Set & save previous and next entry
    // - logic here is to skip insert if entry does not yet exist as evolution
    // reference goes both ways

    return pokemon;
  }

}
