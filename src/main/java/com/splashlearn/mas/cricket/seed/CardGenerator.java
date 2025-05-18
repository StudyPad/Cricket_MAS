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
        attributes.put(CardAttribute.RUNS, random.nextInt(100_001));
        attributes.put(CardAttribute.MATCHES, random.nextInt(501));
        attributes.put(CardAttribute.CENTURIES, random.nextInt(101));
        attributes.put(CardAttribute.HALF_CENTURIES, random.nextInt(81));
        attributes.put(CardAttribute.CATCHES, random.nextInt(381));
        attributes.put(CardAttribute.WICKETS, random.nextInt(961));
        return attributes;
    }
}
