package org.acme.rest;

import org.acme.factory.TasteNamedLiteral;
import org.acme.model.EnumTaste;
import org.acme.model.Fruit;
import org.acme.factory.TasteLiteral;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/programmatically")
public class Programmatically {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public HashMap<String, Object> programmatically() {
    HashMap<String, Object> fruits = new HashMap<>();

    Fruit orangeDefault = null;
    Fruit orangeAnnotationDefault = null;
    Fruit orangeAnnotationBitter = null;
    Fruit appleSweet = null;
    Fruit appleCitric = null;

    try{
      orangeDefault = CDI.current().select(Fruit.class).get();
      fruits.put("orangeDefault", orangeDefault);
    }catch (Exception e){
      fruits.put("orangeDefault", e.getMessage());
    }

    try{
      orangeAnnotationDefault = CDI.current().select(Fruit.class,new TasteLiteral()).get();
      fruits.put("orangeAnnotationDefault", orangeAnnotationDefault);
    }catch (Exception e){
      fruits.put("orangeAnnotationDefault", e.getMessage());
    }

    try{
      orangeAnnotationBitter = CDI.current().select(Fruit.class,new TasteLiteral(EnumTaste.BITTER)).get();
      fruits.put("orangeAnnotationBitter", orangeAnnotationBitter);
    }catch (Exception e){
      fruits.put("orangeAnnotationBitter", e.getMessage());
    }

    try{
      orangeAnnotationBitter = CDI.current().select(Fruit.class,new TasteLiteral(EnumTaste.BITTER)).get();
      fruits.put("orangeAnnotationBitter", orangeAnnotationBitter);
    }catch (Exception e){
      fruits.put("orangeAnnotationBitter", e.getMessage());
    }

    try{
      appleSweet = CDI.current().select(Fruit.class,new TasteNamedLiteral()).get();
      fruits.put("appleSweet", appleSweet);
    }catch (Exception e){
      fruits.put("appleSweet", e.getMessage());
    }
    try{
      appleCitric = CDI.current().select(Fruit.class,new TasteNamedLiteral(EnumTaste.CITRIC)).get();
      fruits.put("appleCitric", appleCitric);
    }catch (Exception e){
      fruits.put("appleCitric", e.getMessage());
    }

    return fruits;
  }
}