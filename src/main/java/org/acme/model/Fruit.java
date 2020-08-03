package org.acme.model;

import java.util.UUID;

public class Fruit {

  private String taste;
  private String name;
  private String id;

  public Fruit(String name, EnumTaste typeFruit) {
    switch (typeFruit){
      case SWEET:
        taste = "Sweet";
        break;
      case BITTER:
        taste = "Bitter";
        break;
      case CITRIC:
        taste = "Citric";
        break;
        default:
          taste ="No Taste";
    }
    this.name = name;
    this.id = UUID.randomUUID().toString();
  }

  public String getTaste() {
    return taste;
  }

  public String getName() {
    return name;
  }

  public void setTaste(String taste) {
    this.taste = taste;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return id + " - " + name + " is " + taste;
  }
}
