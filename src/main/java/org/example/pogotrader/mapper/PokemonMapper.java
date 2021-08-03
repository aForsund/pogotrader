package org.example.pogotrader.mapper;

import org.example.pogotrader.dtos.PokemonEntryDto;
import org.example.pogotrader.dtos.TypeDto;
import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

  PokemonEntryDto pokemonToPokemonDto(PokedexEntry pokemon);

  TypeDto typeToTypeDto(Type type);

}
