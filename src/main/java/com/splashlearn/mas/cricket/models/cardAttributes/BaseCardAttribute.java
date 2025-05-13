package com.splashlearn.mas.cricket.models.cardAttributes;

public abstract class BaseCardAttribute implements ICardAttribute {
  protected String name;
  protected int value;

  protected int minValue;
  protected int maxValue;

  public BaseCardAttribute(String name, int value) {
    this.name = name;
    this.minValue = 0;
    this.maxValue = 100;
    validateValue(value);
  }

  protected void validateValue(int value) {
    if (value < minValue || value > maxValue) {
      throw new IllegalArgumentException("Invalid attribute value");
    }
  }
}
