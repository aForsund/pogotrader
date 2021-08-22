package org.example.pogotrader.mapper;

import java.util.Set;

import org.example.pogotrader.dto.FastMoveDto;
import org.example.pogotrader.dto.FastMoveSlimDto;
import org.example.pogotrader.model.FastMove;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FastMoveMapper {

  FastMoveDto fastMoveToFastMoveDto(FastMove fastMove);

  Set<FastMoveSlimDto> fastMoveSetToFastMoveSlimDtoSet(Set<FastMove> fastMoveSet);

}
