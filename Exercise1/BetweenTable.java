// ILias Pierrakos , AM.4896

public class BetweenTable {
    private CardStack deck; 
    private Card[] tableCards; 
    private Card playerCard; 

    // Constructor
    public BetweenTable(CardStack deck) {
        this.deck = deck;
        this.tableCards = new Card[2];
    }

    //Draw 2 cards and stores the smaller one first
    public void drawTableCards() {
        this.tableCards[0] = deck.draw();
        this.tableCards[1] = deck.draw();
        System.out.println("Table Cards: " + this.tableCards[0] + ", " + this.tableCards[1]);
    }

    // Return true or false  to show if player lose
    public boolean defaultPlayerLoss() {
        return this.tableCards[0].equals(this.tableCards[1]);
    }

    // Draw Players Card
    public void drawPlayerCard() {
        this.playerCard = deck.draw();
        System.out.println("Player's Card: " + this.playerCard);
    }

    // Return true or false if the number of card is between the 2 cards of the table
    public boolean betweenCard() {
        return this.playerCard.between(this.tableCards);
    }
}
