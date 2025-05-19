package com.splashlearn.mas.cricket.mainApp;

import com.splashlearn.mas.cricket.models.HumanPlayer;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.models.specialModes.*;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.seed.CardGenerator;
import com.splashlearn.mas.cricket.service.BasicComparisonStrategy;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;
import com.splashlearn.mas.cricket.service.GameEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class MainAppApplication {

	public static void main(String[] args) {
		List<SpecialMode> specialModeList = new ArrayList<>();
		specialModeList.add(new FreeHitMode());
		specialModeList.add(new PowerPlayMode(new HashSet<CardAttribute>()));
		specialModeList.add(new WorldCupMode());
		specialModeList.add(new SuperMode());
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
		SpringApplication.run(MainAppApplication.class, args);
	}

}
