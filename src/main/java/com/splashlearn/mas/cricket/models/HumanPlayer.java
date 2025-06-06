package com.splashlearn.mas.cricket.models;

import com.splashlearn.mas.cricket.models.cardAttributes.BaseCardAttribute;
import com.splashlearn.mas.cricket.models.specialModes.SpecialMode;
import com.splashlearn.mas.cricket.models.specialModes.SpecialModeFactory;
import com.splashlearn.mas.cricket.seed.CardAttribute;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@AllArgsConstructor
public class HumanPlayer implements Player {

    private final String name;
    private final String playerId;
    private List<Card> cards;
    private double health;
    private boolean isSpecialModeUsed;
    private boolean specialModeActive;
    private Card selectedCard;
    private SpecialMode selectedSpecialMode;
//    private Map<Integer,SpecialMode>availableSpecialModes;

    public HumanPlayer(String name, String playerId, List<Card> cards) {
        this.name = name;
        this.playerId = playerId;
        this.cards = cards;
        this.health = 100; // default health
        this.isSpecialModeUsed = false; // e.g., player can activate once
        this.specialModeActive = false;
//        this.availableSpecialModes = availableSpecialModes;
        this.selectedSpecialMode = null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPlayerId() {
        return playerId;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void removeHealth(double value) {
        this.health = Math.max(0, health - value);
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void removeCard() {
        if (cards.isEmpty()) return;
        cards.remove(selectedCard);
    }

    @Override
    public boolean isSpecialModeUsed() {
        return this.isSpecialModeUsed;
    }

    @Override
    public void setSpecialModeUsed(boolean status) {
        this.isSpecialModeUsed = status;
    }


    @Override
    public SpecialMode setSpecialModeActive() {
        System.out.println(this.name + " Use your special Mode -" + this.getActiveSpecialMode().getName() + " : (1 for yes 0 for no)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1 ){
            this.specialModeActive = true;
            return selectedSpecialMode;
        }
return null;
    }

    @Override
    public boolean isSpecialModeActive() {
        return specialModeActive;
    }

    @Override
    public Card selectCard() {
        // For human players, this would be input-driven in a real system

        for(int i=1;i<=cards.size(); i++){
            System.out.println("Card : " + i);
            cards.get(i-1).printCardDetails();
        }
        System.out.println(this.name +  " Select a Card: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.print("Enter your choice (1 to " + cards.size() + "): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= cards.size()) {
                    break; // valid input, exit loop
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + cards.size() + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
        }

        Card selectedCard = cards.get(choice - 1);
        setSelectedCard(selectedCard);
        return selectedCard; // placeholder
    }

    @Override
    public Card getSelectedCard(){
        return this.selectedCard;
    }
    @Override
    public void setSelectedCard(Card card){
        this.selectedCard = card;
    }



    @Override
    public List<CardAttribute> selectAttribute(Player player) {
        if (cards.isEmpty()) return null;
        List<CardAttribute> result = new ArrayList<>();
        Card selectedCard = this.getSelectedCard();
        selectedCard.printCardDetails();
        Scanner scanner = new Scanner(System.in);

        if(player.isSpecialModeActive() && !player.isSpecialModeUsed() && player.getActiveSpecialMode().getName().equalsIgnoreCase("Power Play Mode")){
            int j = 2;
            while(j > 0){
               getAttribute(result,selectedCard,scanner);
                j--;
            }
            player.setSpecialModeUsed(true);
        }else if(player.isSpecialModeActive()){
            getAttribute(result,selectedCard,scanner);
            player.setSpecialModeUsed(true);
        }else{
            getAttribute(result,selectedCard,scanner);
        }

        return result; // basic validation assumed
    }

    void getAttribute(List<CardAttribute> result, Card selectedCard, Scanner scanner){
        Map<CardAttribute, BaseCardAttribute> attributes = selectedCard.getAttributes();
        System.out.println("Choose an attribute to compare:");
        List<CardAttribute> attributeList = new ArrayList<>(attributes.keySet());
        int i = 1;
        for (CardAttribute attr : attributeList) {
            System.out.println(i + ". " + attr);
            i++;
        }
        int choice = scanner.nextInt();
        result.add(attributeList.get(choice - 1));
    }

    @Override
    public SpecialMode getActiveSpecialMode() {
        return selectedSpecialMode;
    }

    @Override
    public SpecialMode getSelectedSpecialMode() {
        return selectedSpecialMode;
    }
    @Override
    public void selectSpecialMode(){
        Map<Integer, SpecialMode> specialModeMap = SpecialModeFactory.getAllSpecialModes();
        if(selectedSpecialMode == null){
            System.out.println(this.name + " Your Available Special Modes:");
            for (Map.Entry<Integer, SpecialMode> entry : specialModeMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue().getName());
            }
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            this.selectedSpecialMode = specialModeMap.get(choice);
        }
    }
}
