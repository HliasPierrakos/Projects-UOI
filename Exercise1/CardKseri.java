// ILias Pierrakos , AM.4896

public class CardKseri {
    private String suit;
    private int rank;

    public CardKseri(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        String rankString;
        switch (rank) {
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
        CardKseri otherCard = (CardKseri) obj;
        return rank == otherCard.rank && suit.equals(otherCard.suit);
    }

    public boolean isJack() {
        return rank == 11;
    }

    public boolean isHighCard() {
        return rank >= 10;
    }

    public boolean isTwoClubs() {
        return rank == 2 && suit.equals("Clubs");
    }

    public boolean isTenDiamond() {
        return rank == 10 && suit.equals("Diamonds");
    }
}