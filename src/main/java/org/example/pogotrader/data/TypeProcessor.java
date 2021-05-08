package org.example.pogotrader.data;

import org.example.pogotrader.model.Type;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeProcessor implements ItemProcessor<TypeInput, Type> {

  @Autowired
  private TypeService typeService;

  private HashSet<Type> weakTo;

  @Override
  public Type process(final TypeInput typeInput) throws Exception {

    weakTo = new HashSet<>();

    System.out.println("Hello from TypeProcessor");
    System.out.println("checking if " + typeInput.getName() + " exists: " + typeService.exists(typeInput.getName()));

    Type type;
    if (typeService.exists(typeInput.getName())) {
      type = typeService.findByName(typeInput.getName());
    } else {
      type = new Type();
      type.setName(typeInput.getName());
    }

    System.out.println("I'm now accessing: " + type);
    if (typeInput.getWeakTo() != null) {

      Arrays.stream(typeInput.getWeakTo().split("-")).forEach(item -> {
        System.out.println(item);
        weakTo.add(typeService.findByName(item));

      });

    }
    type.addWeakTo(weakTo);
    System.out.println("Type object: " + type + " - weak to: " + type.getWeakTo());

    return type;

  }

}
