package com.splashlearn.mas.cricket.models;

import com.splashlearn.mas.cricket.models.specialModes.SpecialMode;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@AllArgsConstructor
public class HumanPlayer implements Player {

    private final String name;
    private final String playerId;
    private List<Card> cards;
    private double health;
    private int remainingSpecialMode;
    private boolean specialModeActive;
    private List<SpecialMode> availableSpecialModes;
    private  SpecialMode activeSpecialMode;

    public HumanPlayer(String name, String playerId, List<Card> cards, List<SpecialMode> availableSpecialModes) {
        this.name = name;
        this.playerId = playerId;
        this.cards = cards;
        this.health = 100; // default health
        this.remainingSpecialMode = 1; // e.g., player can activate once
        this.specialModeActive = false;
        this.availableSpecialModes = availableSpecialModes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPlayerId() {
        return playerId;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void removeHealth(double value) {
        this.health = Math.max(0, health - value);
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public Card removeCard() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    @Override
    public int getRemainingSpecialMode() {
        return remainingSpecialMode;
    }


    @Override
    public boolean setSpecialModeActive(String modeName) {
        if (remainingSpecialMode <= 0) return false;

        for (SpecialMode mode : availableSpecialModes) {
            if (mode.getName().equalsIgnoreCase(modeName)) {
                this.specialModeActive = true;
                this.activeSpecialMode = mode;
                remainingSpecialMode--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSpecialModeActive() {
        return specialModeActive;
    }

    @Override
    public Card selectCard() {
        // For human players, this would be input-driven in a real system
        return cards.isEmpty() ? null : cards.get(0); // placeholder
    }

    @Override
    public CardAttribute selectAttribute() {
        if (cards.isEmpty()) return null;

        Card selectedCard = selectCard();
        Map<CardAttribute, Integer> attributes = selectedCard.getAttributes();

        System.out.println("Choose an attribute to compare:");
        int i = 1;
        List<CardAttribute> attributeList = new ArrayList<>(attributes.keySet());
        for (CardAttribute attr : attributeList) {
            System.out.println(i + ". " + attr);
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return attributeList.get(choice - 1); // basic validation assumed
    }

    @Override
    public SpecialMode getActiveSpecialMode() {
        return activeSpecialMode;
    }

}
