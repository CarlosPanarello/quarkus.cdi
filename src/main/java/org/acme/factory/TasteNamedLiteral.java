package org.acme.factory;

import org.acme.model.EnumTaste;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Named;

public class TasteNamedLiteral  extends AnnotationLiteral<Named> implements Named {
  private String value;

  public TasteNamedLiteral() {
    this(EnumTaste.SWEET);
  }

  public TasteNamedLiteral(EnumTaste enumTaste) {

    switch (enumTaste){
      case BITTER:
        this.value = "Bitter";
        break;
      case CITRIC:
        this.value = "Citric";
        break;
      case SWEET:
      default:
        this.value = "Sweet";
    }
  }

  @Override
  public String value() {
    return value;
  }
}
