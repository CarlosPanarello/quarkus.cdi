package org.acme.rest;

import org.acme.model.EnumTaste;
import org.acme.model.Fruit;
import org.acme.factory.Taste;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/injected")
public class Injected {

  @Inject
  @Named("Sweet")
  Fruit apple_sweet;

  @Inject
  @Named("Citric")
  Fruit apple_citric;

  @Inject
  @Taste
  Fruit orangeAnnotationDefault;

  @Inject
  @Taste(taste = EnumTaste.BITTER)
  Fruit orangeAnnotationBitter;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public HashMap<String, Object> injected() {

    HashMap<String, Object> fruits = new HashMap<>();
    fruits.put("orangeAnnotationDefault", orangeAnnotationDefault);
    fruits.put("orangeAnnotationBitter", orangeAnnotationBitter);

    fruits.put("appleSweet", apple_sweet);
    fruits.put("appleCitric", apple_citric);

    return fruits;
  }
}