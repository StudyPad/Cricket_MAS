package com.splashlearn.mas.cricket.models.specialModes;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;

import java.util.List;

public interface SpecialMode {
        void activate(Player player);
        boolean isUsed();
        String getName();
        double getUpdatedDamageDealt(double baseDamage);
        double getUpdatedDamageTaken(double baseDamage);
        int compare(Card playerCard, Card enemyCard, List<CardAttribute> attributes, ComparisonStrategy strategy);
}


