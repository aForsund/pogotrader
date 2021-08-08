package org.example.pogotrader.mapstruct;

import java.util.HashSet;

import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

  HashSet<PokedexEntryDto> pokedexEntryToPokedexEntryDto(HashSet<PokedexEntry> hashSet);

  PokedexEntryDto pokedexEntryToPokedexEntryDto(PokedexEntry pokedexEntry);

  TypeDto typeToTypeDto(Type type);

  TypeSlimDto typeToTypeSlimDto(Type type);

}
