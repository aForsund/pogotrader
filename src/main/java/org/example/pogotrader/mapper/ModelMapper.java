package org.example.pogotrader.mapper;

import java.util.HashSet;

import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  HashSet<PokedexEntryDto> pokedexEntryToPokedexEntryDto(HashSet<PokedexEntry> hashSet);

  PokedexEntryDto pokedexEntryToPokedexEntryDto(PokedexEntry pokedexEntry);

  TypeDto typeToTypeDto(Type type);

  TypeSlimDto typeToTypeSlimDto(Type type);

}
