package com.splashlearn.mas.cricket.models.cardDeck;

import com.splashlearn.mas.cricket.models.Card;

public interface ICardDeck {
    /**
     * This method is used to shuffle the deck of cards.
     */
    void shuffleDeck();

    /**
     * This method is used to draw a card from the deck.
     *
     * @return the drawn card
     */
    Card drawCard();

    /**
     * This method is used to get the size of the deck.
     *
     * @return the size of the deck
     */
    int getDeckSize();
}
