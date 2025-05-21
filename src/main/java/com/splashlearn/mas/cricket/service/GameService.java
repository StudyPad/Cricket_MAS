package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.HumanPlayer;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.seed.CardGenerator;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Scanner;

@Service
public class GameService implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initializeAndStartGame();
    }

    private void initializeAndStartGame() {
        // Game initialization and execution logic
        Scanner sc = new Scanner(System.in);
        // Prompt for player names
        System.out.print("Please enter first player name: ");
        String player1Name = sc.nextLine();

        System.out.print("Please enter second player name: ");
        String player2Name = sc.nextLine();

        // Create players with entered names
        Player player1 = new HumanPlayer(player1Name, "P1", new CardGenerator(new Random()).generateCards(10));
        Player player2 = new HumanPlayer(player2Name, "P2", new CardGenerator(new Random()).generateCards(10));

        ComparisonStrategy strategy = new BasicComparisonStrategy(); // Your implementation
        GameEngine engine = new GameEngine(player1, player2, strategy);
        engine.playGame();
    }
}
