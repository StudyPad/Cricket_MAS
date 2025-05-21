package com.splashlearn.mas.cricket.models.cardAttributes;

public abstract class BaseCardAttribute implements ICardAttribute {
  protected String name;
  protected int value;

  protected final int minValue;
  protected final int maxValue;

  public BaseCardAttribute(String name, int value, int minValue, int maxValue) {
    this.name = name;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.value = value;
  }
  @Override
  public String getAttributeName() {
    return this.name;
  }

  @Override
  public void setAttributeName(String name) {
    this.name = name;
  }

  @Override
  public int getAttributeValue() {
    return this.value;
  }

  @Override
  public void setAttributeValue(int value) {
      this.value = value;
  }
}
