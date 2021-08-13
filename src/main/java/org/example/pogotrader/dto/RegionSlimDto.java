package org.example.pogotrader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegionSlimDto {
    
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;
}
