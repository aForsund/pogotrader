package org.example.pogotrader.mapper;

import java.util.Set;

import org.example.pogotrader.dto.TypeDto;
import org.example.pogotrader.dto.TypeSlimDto;
import org.example.pogotrader.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {

  TypeDto typeToTypeDto(Type type);

  TypeSlimDto typeToTypeSlimDto(Type type);

  Set<TypeSlimDto> typeSetToTypeSlimDtoSet(Set<Type> typeSet);

}
