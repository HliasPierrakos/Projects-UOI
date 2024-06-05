// ILias Pierrakos , AM.4896

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    // Constructor
    public Hand() {
        this.cards = new ArrayList<>();
    }

    // Method to add a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Method to print the hand
    public void print() {
        String cardsString = "";
        String positionsString = "";

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            cardsString += card.toString();
            positionsString += (i + 1);
        
            // Add spacing between cards and positions
            if (i < cards.size() - 1) {
                cardsString += " ";
                positionsString += " ";
            }
        }
        System.out.println(cardsString);
        System.out.println(positionsString);

    }

    // Method to get a card from a specific position
    public Card getCard(int position) {
        if (position >= 1 && position <= cards.size()) {
            return cards.remove(position - 1);
        } else {
            System.out.println("Invalid position!");
            return null;
        }
    }

    // Method to select a card for the computer player
    public Card selectComputerCard(Card topCard) {
        // Check if there is a matching card in the hand
        for (Card card : cards) {
            if (card.getValue() == topCard.getValue()) {
                return cards.remove(cards.indexOf(card));
            }
        }

        // Check if there is a jack in the hand
        for (Card card : cards) {
            if (card.isJack()) {
                return cards.remove(cards.indexOf(card));
            }
        }

        // If no matching card or jack found, return a random card
        return cards.remove((int) (Math.random() * cards.size()));
    }

    // Method to check if the hand is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
