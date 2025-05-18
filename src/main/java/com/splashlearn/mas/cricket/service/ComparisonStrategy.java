package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.seed.CardAttribute;

public interface ComparisonStrategy {
    int compare(Card playerCard, Card enemyCard, CardAttribute attribute); // returns -1, 0, 1
}

