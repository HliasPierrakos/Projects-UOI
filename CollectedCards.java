// ILias Pierrakos , AM.4896

import java.util.ArrayList;

public class CollectedCards {
    private ArrayList<Card> cards;

    public CollectedCards() {
        this.cards = new ArrayList<>();
    }

    public CollectedCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public boolean isXeri() {
        if (cards.size() == 1) {
            Card card = cards.get(0);
            return card.isJack(); 
        }
        return false;
    }

    public boolean isXeriWithJacks() {
        if (cards.size() == 1) {
            Card card = cards.get(0);
            return card.isJack(); 
        } else if (cards.size() == 2) {
            
            return cards.get(0).isJack() && cards.get(1).isJack();
        }
        return false;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
