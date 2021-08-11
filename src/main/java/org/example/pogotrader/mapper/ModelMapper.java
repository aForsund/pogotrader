package org.example.pogotrader.mapper;

import java.util.HashSet;
import java.util.Set;


import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  HashSet<PokedexEntryDto> pokedexEntryToPokedexEntryDto(HashSet<PokedexEntry> hashSet);

  PokedexEntryDto pokedexEntryToPokedexEntryDto(PokedexEntry pokedexEntry);

  
 
  TypeDto typeToTypeDto(Type type);
  
  TypeSlimDto typeToTypeSlimDto(Type type);


  //default HashSet<TypeSlimDto> typeToTypeSlimDto(HashSet<Type> types) {
  //  HashSet<TypeSlimDto> set = new HashSet<>();
  //  for (Type type : types) {
  //    set.add(typeToTypeSlimDto(type));
  //  }
  //  return set;
  //}

  
  HashSet<TypeSlimDto> typingToTypeSlimDtoSet(HashSet<Type> type);

  

  

}
