package com.splashlearn.mas.cricket.seed;

import com.splashlearn.mas.cricket.models.Card;

import java.util.*;

public class CardGenerator {

    private final Random random;

    public CardGenerator(Random random) {
        this.random = random;
    }

    public List<Card> generateCards(int numberOfCards) {
        List<Card> cards = new ArrayList<>();

        for (int i = 1; i <= numberOfCards; i++) {
            String playerName = "Player" + i;
            Map<CardAttribute, Integer> attributes = generateRandomAttributes();
            cards.add(new Card(playerName, attributes));
        }
        return cards;
    }

    private Map<CardAttribute, Integer> generateRandomAttributes() {
        Map<CardAttribute, Integer> attributes = new EnumMap<>(CardAttribute.class);
        for (CardAttribute attribute : CardAttribute.values()) {
            attributes.put(attribute, random.nextInt(attribute.getMaxRange()));
        }
        return attributes;
    }
}
