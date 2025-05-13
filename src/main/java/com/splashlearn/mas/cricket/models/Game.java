package com.splashlearn.mas.cricket.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
  GamePlayer player1;
  GamePlayer player2;
  GamePlayer currentPlayer;
  List<GameTurn> turnHistory;

  public Game(GamePlayer player1, GamePlayer player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.currentPlayer = player1; // Player 1 starts the game
    this.turnHistory = new ArrayList<>();
  }
}
