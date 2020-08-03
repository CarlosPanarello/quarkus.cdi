package org.acme.factory;

import org.acme.model.EnumTaste;
import org.acme.model.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class AppleFactory {

  @Produces
  @Named("Bitter")
  Fruit fruitFactory_bitter() {
    return new Fruit("Apple", EnumTaste.BITTER);
  }

  @Produces
  @Named("Sweet")
  Fruit fruitFactory_sweet() {
    return new Fruit("Apple", EnumTaste.SWEET);
  }

  @Produces
  @Named("Citric")
  Fruit fruitFactory_citric() {
    return new Fruit("Apple", EnumTaste.CITRIC);
  }

}
