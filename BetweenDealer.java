// ILias Pierrakos , AM.4896

import java.util.Arrays;
import java.util.Collections;

public class BetweenDealer {
    private CardStack deck; 
    private int pot; 

    // Constructor
    public BetweenDealer(int initialPot) {
        this.pot = initialPot;
        createAndShuffleDeck();
    }

    // This method help for creating and elements of the stack of cards
    private void createAndShuffleDeck() {
        deck = new CardStack();
        deck.createDeck(6); 
        deck.shuffle(); 
    }

    // Return true or false if dealer is out of money
    public boolean emptyPot() {
        return pot <= 0;
    }

    // implements a round of the game
    public void play(BetweenPlayer player) {
        
        if (deck.size() <= deck.capacity() / 2) {
            createAndShuffleDeck(); 
        }

        
        BetweenTable table = new BetweenTable(deck);

        
        table.drawTableCards();

        
        if (table.defaultPlayerLoss()) {
            pot++; 
            System.out.println("Player loses by default. Pot increased to " + pot);
        } else {
            
            int playerBid = player.bid(pot);

            
            table.drawPlayerCard();

            
            if (table.betweenCard()) {
                
                player.addMoney(playerBid);
                pot -= playerBid;
                System.out.println("Player wins " + playerBid + ". Pot decreased to " + pot);
            } else {
                
                player.subtractMoney(playerBid);
                pot += playerBid;
                System.out.println("Dealer wins " + playerBid + ". Pot increased to " + pot);
            }
        }
    }
}
