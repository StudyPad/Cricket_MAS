package com.splashlearn.mas.cricket.service;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.seed.CardAttribute;

import java.util.List;

public interface ComparisonStrategy {
    int compare(Card playerCard, Card enemyCard, List<CardAttribute> attributes); // returns -1, 0, 1
}

