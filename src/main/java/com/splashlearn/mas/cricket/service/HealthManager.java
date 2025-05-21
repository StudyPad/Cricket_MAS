package com.splashlearn.mas.cricket.service;


import com.splashlearn.mas.cricket.models.Player;

public class HealthManager {
    public void applyDamage(Player loser, Player winner, double baseDamage) {
        double damage = baseDamage;

        if (winner.isSpecialModeActive()) {
            damage = winner.getActiveSpecialMode().getUpdatedDamageDealt(baseDamage);
            loser.removeHealth(damage);
        }else{
            loser.removeHealth(damage * 0.10);
        }

    }
}

