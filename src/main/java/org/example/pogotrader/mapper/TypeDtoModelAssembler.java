package org.example.pogotrader.mapper;

import org.example.pogotrader.controller.TypeController;
import org.example.pogotrader.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class TypeDtoModelAssembler implements RepresentationModelAssembler<Type, TypeDto> {

  @Autowired
  private TypeMapper mapper;

  @Override
  public TypeDto toModel(Type type) {

    // Create DTO
    TypeDto typeDTO = mapper.typeToTypeDto(type);

    // Add link to self
    Link selfLink = linkTo(methodOn(TypeController.class).findById(type.getId())).withSelfRel();
    typeDTO.add(selfLink);

    // Add link for weakTo
    for (TypeSlimDto entry : typeDTO.getWeakTo()) {
      // System.out.println(typeDTO.getName() + " is weak to " + entry.getName());
      Link selfLinkweakTo = linkTo(methodOn(TypeController.class).findById(entry.getId())).withSelfRel();
      entry.add(selfLinkweakTo);

    }

    // Add link for strongAgainst
    for (TypeSlimDto entry : typeDTO.getStrongAgainst()) {
      Link selfLinkStrongAgainst = linkTo(methodOn(TypeController.class).findById(entry.getId())).withSelfRel();
      entry.add(selfLinkStrongAgainst);
    }

    // Add link for notVeryEffectiveAgainst
    for (TypeSlimDto entry : typeDTO.getNotVeryEffectiveAgainst()) {
      Link selfLinkNotVeryEffectiveAgainst = linkTo(methodOn(TypeController.class).findById(entry.getId()))
          .withSelfRel();
      entry.add(selfLinkNotVeryEffectiveAgainst);
    }

    return typeDTO;

  }

  // @Override
  // public static CollectionModel<TypeDto> toCollectionModel(Iterable<? extends
  // Type> typeSet){

  // Set<TypeDto> typeDtoSet = new HashSet<>();

  // for (Type item : typeSet) {
  // TypeDto typeDto = toModel(item);
  // typeDtoSet.add(typeDto);
  // }

  // return new CollectionModel<>(typeDtoSet);
  // }

}
