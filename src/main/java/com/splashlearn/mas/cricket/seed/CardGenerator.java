package com.splashlearn.mas.cricket.seed;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.cardAttributes.*;

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
            Map<CardAttribute, BaseCardAttribute> attributes = generateRandomAttributes();
            cards.add(new Card(playerName, attributes));
        }
        return cards;
    }

    private Map<CardAttribute, BaseCardAttribute> generateRandomAttributes() {
        Map<CardAttribute, BaseCardAttribute> attributes = new EnumMap<>(CardAttribute.class);
        attributes.put(CardAttribute.RUNS, new RunsAttribute(random.nextInt(100_001)));
        attributes.put(CardAttribute.MATCHES, new MatchesAttribute(random.nextInt(501)));
        attributes.put(CardAttribute.CENTURIES, new CenturiesAttribute(random.nextInt(101)));
        attributes.put(CardAttribute.HALF_CENTURIES, new HalfCenturiesAttribute(random.nextInt(81)));
        attributes.put(CardAttribute.CATCHES, new CatchesAttribute(random.nextInt(381)));
        attributes.put(CardAttribute.WICKETS,new WicketsAttribute(random.nextInt(961)));
        return attributes;
    }
}
