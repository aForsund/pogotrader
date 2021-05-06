package org.example.pogotrader.data;

import org.springframework.batch.item.ItemProcessor;
import java.util.Arrays;
import org.example.pogotrader.model.Type;

public class TypePropertiesProcessor implements ItemProcessor<TypePropertiesInput, Type> {

  private TypeService typeService;

  @Override
  public Type process(final TypePropertiesInput typePropertiesInput) throws Exception {

    Type type = typeService.findByName(typePropertiesInput.getName());
    System.out.println("*** now processing " + type);

    if (typePropertiesInput.getWeakTo() != null) {
      Arrays.stream(typePropertiesInput.getWeakTo().split("-")).forEach(item -> {
        System.out.println(item);
        type.addWeakTo(typeService.findByName(item));
      });
    }

    return type;

  }
}
