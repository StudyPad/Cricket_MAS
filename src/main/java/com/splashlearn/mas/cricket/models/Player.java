package com.splashlearn.mas.cricket.models;

import com.splashlearn.mas.cricket.models.specialModes.SpecialMode;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.seed.Mode;

import java.util.List;

public interface Player {

    String getName();
    String getPlayerId();
    double getHealth();
    void removeHealth(double value);
    List<Card> getCards();
    Card removeCard();
    boolean  isSpecialModeUsed();
    SpecialMode setSpecialModeActive();
    boolean isSpecialModeActive();
    Card selectCard(); // different for human vs. AI
    CardAttribute selectAttribute();
    SpecialMode getActiveSpecialMode();
    public SpecialMode getSelectedSpecialMode();
    void selectSpecialMode();
    Card getSelectedCard();
    void setSelectedCard(Card card);
}
