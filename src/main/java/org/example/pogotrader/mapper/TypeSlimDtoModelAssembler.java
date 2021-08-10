package org.example.pogotrader.mapper;

import org.example.pogotrader.controller.TypeController;
import org.example.pogotrader.model.Type;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class TypeSlimDtoModelAssembler implements RepresentationModelAssembler<Type, TypeSlimDto> {

    private MapStructMapper mapper;

    @Override
    public TypeSlimDto toModel(Type type) {

        TypeSlimDto typeDTO = mapper.typeToTypeSlimDto(type);
        Link selfLink = linkTo(methodOn(TypeController.class).findById(type.getId())).withSelfRel();
        typeDTO.add(selfLink);


        return typeDTO;
        
    }
    
    
}
