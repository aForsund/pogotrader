package org.example.pogotrader.mapper;

import org.example.pogotrader.dto.RegionDto;
import org.example.pogotrader.dto.RegionSlimDto;
import org.example.pogotrader.model.Region;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    RegionDto regionToRegionDto(Region region);

    RegionSlimDto regionToRegionSlimDto(Region region);
    
}
