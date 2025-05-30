package com.splashlearn.mas.cricket.models.specialModes;

import com.splashlearn.mas.cricket.enums.SpecialModeEnum;
import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;

import java.util.List;
import java.util.Set;

public class PowerPlayMode implements SpecialMode {
    private final Set<CardAttribute> attributes;

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

    public PowerPlayMode(Set<CardAttribute> attributes) {
        this.attributes = attributes;
    }



    @Override
    public String getName() {
        return SpecialModeEnum.POWER_PLAY.getName();
    }

    @Override
    public double getUpdatedDamageDealt(double baseDamage) {
        return (baseDamage * 0.10); // 10% damage
    }

    @Override
    public double getUpdatedDamageTaken(double baseDamage) {
        return baseDamage;
    }

    @Override
    public int compare(Card playerCard, Card enemyCard, List<CardAttribute> attributes, ComparisonStrategy strategy) {
             return strategy.compare(playerCard, enemyCard, attributes);

    }

}

