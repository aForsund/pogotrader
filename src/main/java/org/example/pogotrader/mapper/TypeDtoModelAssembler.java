package org.example.pogotrader.mapper;

import org.example.pogotrader.controller.TypeController;
import org.example.pogotrader.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class TypeDtoModelAssembler implements RepresentationModelAssembler<Type, TypeDto>{
    
    @Autowired
    private ModelMapper mapper;

  @Override
  public TypeDto toModel(Type type) {

    TypeDto typeDTO = mapper.typeToTypeDto(type);
    System.out.println("Type: " + typeDTO.getName() + ", weak to: " + type.getWeakTo());
    Link selfLink = linkTo(methodOn(TypeController.class).findById(type.getId())).withSelfRel();
    typeDTO.add(selfLink);


    //Add url for weakTo 
    for (TypeSlimDto entry : typeDTO.getWeakTo()) {
      System.out.println(typeDTO.getName() + " is weak to " + entry.getName());
      Link selfLink2 = linkTo(methodOn(TypeController.class).findById(entry.getId())).withSelfRel();
      entry.add(selfLink2);

    }

    //Add url for strongAgainst
    for (TypeSlimDto entry : typeDTO.getStrongAgainst()) {
      Link selfLinkStrongAgainst = linkTo(methodOn(TypeController.class).findById(entry.getId())).withSelfRel();
      entry.add(selfLinkStrongAgainst);
    }

    //Add url for notVeryEffectiveAgainst
    for (TypeSlimDto entry : typeDTO.getNotVeryEffectiveAgainst()) {
      Link selfLinkNotVeryEffectiveAgainst = linkTo(methodOn(TypeController.class).findById(entry.getId())).withSelfRel();
      entry.add(selfLinkNotVeryEffectiveAgainst);
    }

    return typeDTO;

  }

}







  