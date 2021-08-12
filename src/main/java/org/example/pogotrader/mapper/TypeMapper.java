package org.example.pogotrader.mapper;

import java.util.HashSet;
import java.util.Set;

import org.example.pogotrader.model.PokedexEntry;
import org.example.pogotrader.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    TypeDto typeToTypeDto(Type type);

    TypeSlimDto typeToTypeSlimDto(Type type);

    Set<TypeSlimDto> typeSetTypeSlimDtoSet(Set<Type> typeSet);

}
