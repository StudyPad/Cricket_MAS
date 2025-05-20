package com.splashlearn.mas.cricket.models.playerHand;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.models.specialModes.SpecialMode;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;
import com.splashlearn.mas.cricket.service.HealthManager;

import java.util.List;

public class PlayerHand {

    private final Player p1;
    private final Player p2;
    private final ComparisonStrategy strategy;
    private final HealthManager healthManager;
    private SpecialMode specialMode;

    public PlayerHand(Player p1, Player p2, ComparisonStrategy strategy, HealthManager healthManager) {
        this.p1 = p1;
        this.p2 = p2;
        this.strategy = strategy;
        this.healthManager = healthManager;
        this.specialMode = null;
    }

    public void play() {
        // 1. Setup phase
        setupRound();

        // 2. Card selection phase
        Card card1 = selectCardFromPlayer(p1);
        List<CardAttribute> selectedAttributes = p1.selectAttribute(p1);
        Card card2 = selectCardFromPlayer(p2);

        // 3. Comparison phase
        int result = compareCards(card1, card2, selectedAttributes);

        // 4. Resolution phase
        resolveRound(result, p1, p2);

        // 5. Cleanup phase
        cleanupRound(card1, card2);
    }

    /**
     * Setup the round by checking special modes
     */
    private void setupRound() {
        p1.selectSpecialMode();
        p2.selectSpecialMode();

        if (!p1.isSpecialModeUsed()) {
            specialMode = p1.setSpecialModeActive();
        }
    }

    /**
     * Handle card selection for a player
     */
    private Card selectCardFromPlayer(Player player) {
        return player.selectCard();
    }

    /**
     * Compare the attribute values between two cards
     */
    private int compareCards(Card card1, Card card2, List<CardAttribute> selectedAttributes) {
        if (card1 == null || card2 == null || selectedAttributes == null || selectedAttributes.isEmpty()) {
            System.out.println("Invalid input: cards or attributes missing.");
            return 0;
        }


        for (CardAttribute selectedAttribute : selectedAttributes) {
            Integer value1 = getAttributeValue(card1, selectedAttribute);
            Integer value2 = getAttributeValue(card2, selectedAttribute);

            if (value1 == null || value2 == null) {
                System.out.println("Attribute " + selectedAttribute + " missing on one of the cards.");
                continue; // Skip to the next attribute
            }

            displayAttributeValues(p1, p2, value1, value2, selectedAttribute);


        }
        int result = performComparison(card1, card2, selectedAttributes);
        return result;
    }

    /**
     * Get attribute value from a card
     */
    private Integer getAttributeValue(Card card, CardAttribute attribute) {
        return card.getAttributes().get(attribute).getAttributeValue();
    }

    /**
     * Display the attribute values for both players
     */
    private void displayAttributeValues(Player p1, Player p2, Integer value1, Integer value2, CardAttribute attribute) {
        System.err.println(p1.getName() + " has " + value1 + " " + attribute);
        System.err.println(p2.getName() + " has " + value2 + " " + attribute);
    }

    /**
     * Perform comparison using appropriate strategy
     */
    private int performComparison(Card card1, Card card2, List<CardAttribute> selectedAttributes) {
        if (specialMode != null) {
            return specialMode.compare(card1, card2, selectedAttributes, strategy);
        } else {
            return strategy.compare(card1, card2, selectedAttributes);
        }
    }

    /**
     * Resolve the round based on comparison result
     */
    private void resolveRound(int result, Player p1, Player p2) {
        if (result > 0) {
            healthManager.applyDamage(p2, p1, p2.getHealth()); // p1 wins
        } else if (result < 0) {
            healthManager.applyDamage(p1, p2, p1.getHealth()); // p2 wins
        } else {
            System.out.println("It's a tie! No damage dealt.");
        }
    }

    /**
     * Clean up after the round
     */
    private void cleanupRound(Card card1, Card card2) {
        p1.getCards().remove(card1);
        p2.getCards().remove(card2);
        specialMode = null;
    }

}
