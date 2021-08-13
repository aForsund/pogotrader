package org.example.pogotrader.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegionDto extends RepresentationModel<RegionDto> {
    
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Set<PokedexEntrySlimDto> regionEntries;
}
