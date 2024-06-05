// ILias Pierrakos , AM.4896

import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> cards;
    private Card topCard;

    // Constructor
    public Pile() {
        this.cards = new ArrayList<>();
        this.topCard = null;
    }

    // Methods
    public void fill(CardStack cardStack) {
        for (int i = 0; i < 4; i++) {
            Card card = cardStack.draw();
            cards.add(card);
            topCard = card;
        }
    }

    public CollectedCards drop(Card card) {
        ArrayList<Card> collectedCards = new ArrayList<>();
        boolean foundMatchingCard = false;
        
        for (int i = cards.size() - 1; i >= 0; i--) {
            if (cards.get(i).getValue() == card.getValue()) {
                collectedCards.addAll(cards.subList(i, cards.size()));
                cards.removeAll(cards.subList(i, cards.size()));
                if (!cards.isEmpty()) {
                    topCard = cards.get(cards.size() - 1);
                } else {
                    topCard = null;
                }
                foundMatchingCard = true;
                break;
            }
        }
        
        if (!foundMatchingCard) {
            cards.add(card);
            topCard = card;
        }
        
        return new CollectedCards(collectedCards);
    }

    public Card getTopCard() {
        return topCard;
    }

    public void printTopCard() {
        if (topCard != null) {
            System.out.println(topCard.toString());
        } else {
            System.out.println("-");
        }
    }

    public String toString() {
        if (cards.size() != 0) {
            String result = "";
            for (Card card : cards) {
                result += card.toString() + " ";
            }
            return result.trim();  
        } else {
            return "-";
        }
    }
}
