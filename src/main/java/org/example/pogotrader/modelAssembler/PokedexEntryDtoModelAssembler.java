package org.example.pogotrader.modelAssembler;

import java.util.HashSet;
import java.util.Set;

import org.example.pogotrader.dto.PokedexEntryDto;
import org.example.pogotrader.mapper.PokedexEntryMapper;
import org.example.pogotrader.model.PokedexEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PokedexEntryDtoModelAssembler implements RepresentationModelAssembler<PokedexEntry, PokedexEntryDto> {

    @Autowired
    private PokedexEntryMapper mapper;

    @Override
    public PokedexEntryDto toModel(PokedexEntry pokedexEntry) {
        System.out.println("Hello from toModel");
        PokedexEntryDto entryDto = mapper.pokedexEntryToPokedexEntryDto(pokedexEntry);
        return entryDto;
    }

    
    public Set<PokedexEntryDto> toSet(Set<PokedexEntry> pokedexEntries) {
        Set<PokedexEntryDto> set = new HashSet<>();
        for (PokedexEntry entry : pokedexEntries) {
            System.out.println("for loop - " + entry);
            set.add(this.toModel(entry));
        }
        return set;
    }
}
    

