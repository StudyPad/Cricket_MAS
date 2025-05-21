package com.splashlearn.mas.cricket.models;

import com.splashlearn.mas.cricket.models.cardAttributes.BaseCardAttribute;
import com.splashlearn.mas.cricket.seed.CardAttribute;



import java.util.Map;


public class Card {
  private  String playerName;
  private  Map<CardAttribute, BaseCardAttribute> attributes;

  public Card(String playerName, Map<CardAttribute, BaseCardAttribute> attributes) {
    this.playerName = playerName;
    this.attributes = attributes;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public Map<CardAttribute, BaseCardAttribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<CardAttribute, BaseCardAttribute> attributes) {
    this.attributes = attributes;
  }

  public void printCardDetails(){
    System.out.println("Player Name : " + playerName);
    for (Map.Entry<CardAttribute, BaseCardAttribute> entry : attributes.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue().getAttributeValue());
    }
  }
}
