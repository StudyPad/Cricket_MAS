package com.splashlearn.mas.cricket.models.specialModes;

import com.splashlearn.mas.cricket.enums.SpecialModeEnum;
import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;

import java.util.List;

public class FreeHitMode implements SpecialMode {
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
        return SpecialModeEnum.FREE_HIT.getName();
    }

    @Override
    public double getUpdatedDamageDealt(double baseDamage) {
        return  (baseDamage * 1.125); // +12.5%
    }

    @Override
    public double getUpdatedDamageTaken(double baseDamage) {
        return (baseDamage * 1.15); // +15%
    }

    @Override
    public int compare(Card playerCard, Card enemyCard, List<CardAttribute> attributes, ComparisonStrategy strategy) {
        return strategy.compare(playerCard, enemyCard,attributes);
    }


}


