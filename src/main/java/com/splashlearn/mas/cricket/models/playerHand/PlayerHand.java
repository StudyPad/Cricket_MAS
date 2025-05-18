package com.splashlearn.mas.cricket.models.playerHand;

import com.splashlearn.mas.cricket.models.Card;
import com.splashlearn.mas.cricket.models.Player;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import com.splashlearn.mas.cricket.service.ComparisonStrategy;
import com.splashlearn.mas.cricket.service.HealthManager;

public class PlayerHand {

    private final Player p1;
    private final Player p2;
    private final ComparisonStrategy strategy;
    private final HealthManager healthManager;

    public PlayerHand(Player p1, Player p2, ComparisonStrategy strategy, HealthManager healthManager) {
        this.p1 = p1;
        this.p2 = p2;
        this.strategy = strategy;
        this.healthManager = healthManager;
    }

    public void play() {
        // 1. Players select cards
        Card card1 = p1.selectCard();
        Card card2 = p2.selectCard();

        // 2. Players select an attribute (could be based on their own strategy or input)
        CardAttribute selectedAttribute = p1.selectAttribute(); // assuming both compare same attribute

        // 3. Get values for the selected attribute from both cards
        Integer value1 = card1.getAttributes().get(selectedAttribute);
        Integer value2 = card2.getAttributes().get(selectedAttribute);

        if (value1 == null || value2 == null) {
            System.out.println("Attribute missing on one of the cards.");
            return;
        }else{
            System.err.println(p1.getName() + " has " + value1 + " " + selectedAttribute);
            System.err.println(p2.getName() + " has " + value2 + " " + selectedAttribute);
        }

        // 4. Compare values
        int result = Integer.compare(value1, value2);

        // 5. Apply result using your strategy
        if (result > 0) {
            healthManager.applyDamage( p2, p1, 10); // p1 wins
        } else if (result < 0) {
            healthManager.applyDamage(p1, p2, 10); // p2 wins
        } else {
            System.out.println("It's a tie! No damage dealt.");
        }

        // 6. Remove used cards from hand
        p1.getCards().remove(card1);
        p2.getCards().remove(card2);
    }

}
