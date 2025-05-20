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

@SpringBootApplication(scanBasePackages = "com.splashlearn.mas.cricket")
public class MainAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}

}
