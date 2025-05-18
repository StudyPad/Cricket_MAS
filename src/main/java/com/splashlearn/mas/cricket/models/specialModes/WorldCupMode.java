package com.splashlearn.mas.cricket.models.specialModes;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.seed.Mode;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;

public class WorldCupMode implements SpecialMode {

    private boolean used = false;

    @Override
    public void activate(Player player) {
        this.used = true;
        System.out.println(player.getName() + " activated Free Hit Mode!");
    }

    @Override
    public boolean isUsed() {
        return used;
    }


    @Override
    public String getName() {
        return Mode.WorldCupMode.getName();
    }

    @Override
    public double getUpdatedDamageDealt(double baseDamage) {
        return  baseDamage * 2;
    }

    @Override
    public double getUpdatedDamageTaken(double baseDamage) {
        return baseDamage;
    }

    @Override
    public int compare(Card playerCard, Card enemyCard, CardAttribute attribute, ComparisonStrategy strategy) {
        return strategy.compare(playerCard, enemyCard, attribute);
    }
}

