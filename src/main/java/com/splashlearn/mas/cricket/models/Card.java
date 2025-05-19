package com.splashlearn.mas.cricket.models;

import com.splashlearn.mas.cricket.seed.CardAttribute;



import java.util.Map;


public class Card {
  private  String playerName;
  private  Map<CardAttribute, Integer> attributes;

  public Card(String playerName, Map<CardAttribute, Integer> attributes) {
    this.playerName = playerName;
    this.attributes = attributes;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public Map<CardAttribute, Integer> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<CardAttribute, Integer> attributes) {
    this.attributes = attributes;
  }

  public void printCardDetails(){
    System.out.println("Player Name : " + playerName);
    for (Map.Entry<CardAttribute, Integer> entry : attributes.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
