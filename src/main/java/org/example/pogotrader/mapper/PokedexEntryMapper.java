package org.example.pogotrader.mapper;

import java.util.Set;

import org.example.pogotrader.dto.PokedexEntryDto;
import org.example.pogotrader.dto.PokedexEntrySlimDto;
import org.example.pogotrader.model.PokedexEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokedexEntryMapper {

  Set<PokedexEntryDto> pokedexEntryToPokedexEntryDto(Set<PokedexEntry> hashSet);

  PokedexEntryDto pokedexEntryToPokedexEntryDto(PokedexEntry pokedexEntry);

  Set<PokedexEntrySlimDto> pokedexEntryToPokedexEntrySlimDto(Set<PokedexEntry> hashSet);

  PokedexEntrySlimDto pokedexEntryToPokedexEntrySlimDto(PokedexEntry pokedexEntry);

}
