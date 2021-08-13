package org.example.pogotrader.data;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

import org.example.pogotrader.model.PokedexEntry;

public class PokedexProcessor implements ItemProcessor<PokedexInput, PokedexEntry> {

  @Autowired
  private TypeService typeService;

  @Autowired
  private RegionService regionService;

  @Autowired
  private PokedexService pokedexService;

  @Override
  public PokedexEntry process(final PokedexInput pokedexInput) throws Exception {

    PokedexEntry pokemon;
    if (pokedexService.exists(Integer.parseInt(pokedexInput.getId()))) {
      pokemon = pokedexService.findById(Integer.parseInt(pokedexInput.getId()));
      System.out.println("pokemon exists: " + pokemon);

    } else {
      System.out.println("Entry does not exist - creating");
      pokemon = new PokedexEntry();
      pokemon.setName(pokedexInput.getName());
      pokemon.setId(Integer.parseInt(pokedexInput.getId()));
      pokemon.setNumber(Integer.valueOf(pokedexInput.getNumber()));

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
      System.out.println("created: " + pokemon);
      return pokemon;
    }

    // Set & save region
    System.out.println("adding region");
    pokemon.setRegion(regionService.findById(Integer.parseInt(pokedexInput.getRegion())));
    regionService.findById(Integer.parseInt(pokedexInput.getRegion())).addRegionEntry(pokemon);
    // regionService.save(regionService.findById(Integer.parseInt(pokedexInput.getRegion())));

    // Set & save type
    System.out.println("Hello from PokedexProcessor - adding typings");
    if (!(pokedexInput.getTypeOne().isEmpty())) {
      System.out.println("Trying to add " + pokedexInput.getTypeOne());
      System.out.println(typeService.findByName(pokedexInput.getTypeOne()));
      pokemon.addTyping(typeService.findByName(pokedexInput.getTypeOne()));

      typeService.findByName(pokedexInput.getTypeOne()).addPokedexEntry(pokemon);
      // typeService.save(typeService.findByName(pokedexInput.getTypeOne()));
    }

    if (!(pokedexInput.getTypeTwo().isEmpty())) {
      System.out.println("Trying to add " + pokedexInput.getTypeTwo());
      pokemon.addTyping(typeService.findByName(pokedexInput.getTypeTwo()));

      typeService.findByName(pokedexInput.getTypeTwo()).addPokedexEntry(pokemon);
      // typeService.save(typeService.findByName(pokedexInput.getTypeTwo()));
    }

    // Set & save previous and next entry
    // - logic here is to skip insert if entry does not yet exist as evolution
    // reference goes both ways
    if (!(pokedexInput.getNextEvolution().isEmpty())) {
      PokedexEntry nextEvolution = pokedexService.findById(Integer.parseInt(pokedexInput.getNextEvolution()));
      System.out.println("nextEvolution");
      System.out.println(nextEvolution);
      if (!(Objects.isNull(nextEvolution))) {
        pokemon.setNextEvolution(pokedexService.findById(Integer.parseInt(pokedexInput.getNextEvolution())));
        pokedexService.findById(nextEvolution.getId()).setPrevEvolution(pokemon);
        // pokedexService.save(pokedexService.findById(Integer.parseInt(pokedexInput.getNextEvolution())));
      }

    }

    if (!(pokedexInput.getPrevEvolution().isEmpty())) {
      PokedexEntry prevEvolution = pokedexService.findById(Integer.parseInt(pokedexInput.getPrevEvolution()));
      System.out.println("prevEvolution");
      System.out.println(prevEvolution);
      if (!(Objects.isNull(prevEvolution))) {
        pokemon.setPrevEvolution(pokedexService.findById(Integer.parseInt(pokedexInput.getPrevEvolution())));
        pokedexService.findById(prevEvolution.getId()).setNextEvolution(pokemon);
        // pokedexService.save(pokedexService.findById(Integer.parseInt(pokedexInput.getPrevEvolution())));

        System.out.println("added " + prevEvolution + " as previous evolution to " + pokemon);

      }

    }

    return pokemon;
  }

}
