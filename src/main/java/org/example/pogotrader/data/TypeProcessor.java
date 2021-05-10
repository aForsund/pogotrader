package org.example.pogotrader.data;

import org.example.pogotrader.model.Type;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class TypeProcessor implements ItemProcessor<TypeInput, Type> {

  @Autowired
  private TypeService typeService;

  @Override
  public Type process(final TypeInput typeInput) throws Exception {

    System.out.println("Hello from TypeProcessor");
    System.out.println("checking if " + typeInput.getName() + " exists: " + typeService.exists(typeInput.getName()));

    Type type;
    if (typeService.exists(typeInput.getName())) {
      type = typeService.findByName(typeInput.getName());

    } else {
      type = new Type();
      type.setName(typeInput.getName());
      return type;
    }

    System.out.println("I'm now accessing: " + type);

    if (!(typeInput.getWeakTo().isEmpty())) {

      Arrays.stream(typeInput.getWeakTo().split("-")).forEach(item -> {
        type.addWeakTo(typeService.findByName(item));
        typeService.findByName(item).addStrongAgainst(type);
      });

    }

    if (!(typeInput.getResistantTo().isEmpty())) {

      Arrays.stream(typeInput.getResistantTo().split("-")).forEach(item -> {
        type.addResistantTo(typeService.findByName(item));
        typeService.findByName(item).addNotVeryEffectiveAgainst(type);
      });
    }

    if (!(typeInput.getImmuneTo().isEmpty())) {
      Arrays.stream(typeInput.getImmuneTo().split("-")).forEach(item -> {
        type.addImmuneTo(typeService.findByName(item));
        typeService.findByName(item).addNotEffectiveAgainst(type);
      });
    }
    return type;

  }

}
