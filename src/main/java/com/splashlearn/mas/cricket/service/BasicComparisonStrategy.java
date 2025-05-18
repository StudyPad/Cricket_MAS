package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.seed.CardAttribute;

public class BasicComparisonStrategy implements  ComparisonStrategy{
    @Override
    public int compare(Card playerCard, Card enemyCard, CardAttribute attribute) {
        return Integer.compare(playerCard.getAttributes().get(attribute), enemyCard.getAttributes().get(attribute));
    }
}
