package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.seed.CardAttribute;

public class BasicComparisonStrategy implements  ComparisonStrategy{
    @Override
    public int compare(Card playerCard, Card enemyCard, CardAttribute attribute) {
        if (playerCard == null || enemyCard == null) {
            throw new IllegalArgumentException("Cards cannot be null");
        }

        Integer playerValue = playerCard.getAttributes().get(attribute);
        Integer enemyValue = enemyCard.getAttributes().get(attribute);

        if (playerValue == null || enemyValue == null) {
            throw new IllegalArgumentException("Attribute " + attribute + " not found in one of the cards");
        }

        return Integer.compare(playerCard.getAttributes().get(attribute), enemyCard.getAttributes().get(attribute));
    }
}