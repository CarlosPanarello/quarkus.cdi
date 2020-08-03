package org.acme.factory;

import org.acme.factory.Taste;
import org.acme.model.EnumTaste;

import javax.enterprise.util.AnnotationLiteral;

public class TasteLiteral extends AnnotationLiteral<Taste> implements Taste {
  private EnumTaste enumTaste;

  public TasteLiteral(EnumTaste enumTaste) {
    this.enumTaste = enumTaste;
  }
  public TasteLiteral() {
    this.enumTaste = EnumTaste.SWEET;
  }

  @Override
  public EnumTaste taste() {
    return enumTaste;
  }
}