// ILias Pierrakos , AM.4896

public class CardBetween {
    private String suit;
    private int rank;

    public Card(String suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public String toString() {
        String rankString;
        switch(rank) {
            case 11:
                rankString = "J";
                break;
            case 12:
                rankString = "Q";
                break;
            case 13:
                rankString = "K";
                break;
            case 14:
                rankString = "A";
                break;
            default:
                rankString = String.valueOf(rank);
        }
        return rankString + suit;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return rank == otherCard.rank;
    }

    // Method to check if two cards are continuous
    public boolean consecutive(Card otherCard) {
        return Math.abs(this.rank - otherCard.rank) == 1;
    }

    // Method to check if one card is bigger than another
    public boolean greaterThan(Card otherCard) {
        return this.rank > otherCard.rank;
    }

    // Method to check if one card is between two others
    public boolean between(Card[] cards) {
        return this.rank > cards[0].rank && this.rank < cards[1].rank;
    }
}