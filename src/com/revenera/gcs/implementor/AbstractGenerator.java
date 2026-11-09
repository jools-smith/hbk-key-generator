package com.revenera.gcs.implementor;

public abstract class AbstractGenerator implements GeneratorInterface{

  private GeneratorImplementor getGeneratorImplementor() {
    GeneratorImplementor annotation =
        getClass().getAnnotation(GeneratorImplementor.class);

    if (annotation == null) {
      throw new IllegalStateException(
          "Missing @GeneratorImplementor on " + getClass().getName()
      );
    }

    return annotation;
  }

  public final String getTechnologyId() {
    return getGeneratorImplementor().technologyId();
  }

  public final String getTechnologyName() {
    return getGeneratorImplementor().technologyName();
  }
}