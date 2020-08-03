package org.acme.factory;

import io.quarkus.arc.profile.UnlessBuildProfile;
import org.acme.model.EnumTaste;
import org.acme.model.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.annotation.Annotation;

@ApplicationScoped
public class OrangeFactory {

  @Produces
  @Default
  Fruit fruitFactory() {
    return new Fruit("Orange",EnumTaste.SWEET);
  }

  @Produces
  @Taste
  Fruit fruitFactory(InjectionPoint ip)  {
    Taste annotationTaste = null;
    for (Annotation annotation : ip.getQualifiers()) {
      if (annotation instanceof Taste) {
        annotationTaste = (Taste) annotation;
      }
    }

    return new Fruit("Orange",annotationTaste.taste());
  }

}
