package com.splashlearn.mas.cricket.models;

import java.util.HashMap;

import com.splashlearn.mas.cricket.models.cardAttributes.ICardAttribute;

import lombok.Data;

@Data
public class Card {
  private String playerName;
  private HashMap<String, ICardAttribute> cardAttributes;
}
