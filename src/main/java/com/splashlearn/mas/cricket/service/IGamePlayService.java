package com.splashlearn.mas.cricket.service;

import org.springframework.stereotype.Service;

import com.splashlearn.mas.cricket.models.Game;
import com.splashlearn.mas.cricket.models.GamePlayer;
import com.splashlearn.mas.cricket.models.GameTurn;

@Service
public interface IGamePlayService {
  void startGame(Game game, GamePlayer player1, GamePlayer player2); // init random game deck; deal cards to players;
  void performPreGameOperation(Game game, GamePlayer player); // select special mode;
  GameTurn createTurn(Game game, GamePlayer player); // create a new turn for the players; define turnOrder;
  void playTurn(Game game, GamePlayer player, GameTurn turn); // select if want to execute special mode (only if not yet executed); choose a card to play; choose a cardAttribute to compare;
  void markTurnEnd(Game game);
  void endGame(Game game);
}
