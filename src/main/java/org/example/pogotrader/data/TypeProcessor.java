package org.example.pogotrader.data;

import org.example.pogotrader.model.Type;

import org.springframework.batch.item.ItemProcessor;

public class TypeProcessor implements ItemProcessor<TypeInput, Type> {

  @Override
  public Type process(final TypeInput typeInput) throws Exception {

    Type type = new Type();
    type.setName(typeInput.getName());

    System.out.println(type);

    return type;
  }

}
