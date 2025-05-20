package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.seed.CardAttribute;

import java.util.List;

public class BasicComparisonStrategy implements  ComparisonStrategy{
    @Override
    public int compare(Card playerCard, Card enemyCard, List<CardAttribute> attributes) {
        if (playerCard == null || enemyCard == null) {
            throw new IllegalArgumentException("Cards cannot be null");
        }

        if (attributes == null || attributes.isEmpty()) {
            throw new IllegalArgumentException("Attributes list cannot be null or empty");
        }

        if (attributes.size() >= 2) {
            for (CardAttribute attr : attributes) {
                Integer playerValue = playerCard.getAttributes().get(attr).getAttributeValue();
                Integer enemyValue = enemyCard.getAttributes().get(attr).getAttributeValue();

                if (playerValue == null || enemyValue == null) {
                    throw new IllegalArgumentException("Attribute " + attr + " not found in one of the cards");
                }

                if (playerValue > enemyValue) {
                    return 1;
                }
            }

            // If no attribute was greater, check if all were equal
            return -1;
        } else {
            // Fallback: compare based on a single attribute
            CardAttribute attr = attributes.get(0);
            Integer playerValue = playerCard.getAttributes().get(attr).getAttributeValue();
            Integer enemyValue = enemyCard.getAttributes().get(attr).getAttributeValue();

            if (playerValue == null || enemyValue == null) {
                throw new IllegalArgumentException("Attribute " + attr + " not found in one of the cards");
            }

            return Integer.compare(playerValue, enemyValue);
        }
    }
}