package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.models.playerHand.PlayerHand;
import com.splashlearn.mas.cricket.models.specialModes.SpecialMode;
import com.splashlearn.mas.cricket.models.specialModes.SpecialModeFactory;

import java.util.Map;

public class GameEngine {
    private  Player player1;
    private  Player player2;
    private final ComparisonStrategy strategy;
    private final HealthManager healthManager;

    public GameEngine(Player p1, Player p2, ComparisonStrategy strategy) {
        this.player1 = p1;
        this.player2 = p2;
        this.strategy = strategy;
        this.healthManager = new HealthManager();
    }

    public void playGame() {
        while (!isGameOver() && !player1.getCards().isEmpty()) {

            System.out.println("Current turn: " + player1.getName());
            System.out.println("Health remained for " + player1.getName() + " is " + player1.getHealth());
            System.out.println("Health remained for " + player2.getName() + " is " + player2.getHealth());
            PlayerHand turn = new PlayerHand(player1, player2, strategy, healthManager);
            turn.play();
            swapPlayers();
        }
        System.out.println("Health remained for " + player1.getName() + " is " + player1.getHealth());
        System.out.println("Health remained for " + player2.getName() + " is " + player2.getHealth());
        if(player1.getHealth() > player2.getHealth()){
            System.out.println("Congratulations!!! Winner is  " + player1.getName());
        }else if(player1.getHealth() < player2.getHealth()){
            System.out.println("Congratulations Winner!!! is " + player2.getName());
        }else{
            System.out.println("Congratulations game is tie!!!!" );
        }

    }

    private void swapPlayers() {
        Player temp = player1;
        player1 = player2;
        player2 = temp;
    }

    private boolean isGameOver() {
        return player1.getHealth() <= 0 || player2.getHealth() <= 0;
    }
}

