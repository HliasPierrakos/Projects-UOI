// ILias Pierrakos , AM.4896

import java.util.ArrayList;
import java.util.Scanner;

public class XeriPlayer {
    private String playerName;
    private Hand hand;
    private ArrayList<Card> collectedCards;
    private int xeriCount;
    private int points;

    // Constructor
    public XeriPlayer(String playerName) {
        this.playerName = playerName;
        this.hand = new Hand();
        this.collectedCards = new ArrayList<>();
        this.xeriCount = 0;
        this.points = 0;
    }

    // Method to distribute 6 cards to the player
    public void getCards(CardStack deck) {
        for (int i = 0; i < 6; i++) {
            hand.addCard(deck.deal());
        }
    }

    // Method to select a card from the player's hand
    public Card selectCard() {
        System.out.println("Your hand:");
        hand.print();
        System.out.print("Enter the position of the card you want to play: ");
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        return hand.getCard(position);
    }

    // Method for the computer player to select a card
    public Card selectComputerCard(Card topCard) {
        System.out.println(playerName + "'s hand:");
        hand.print();
        return hand.selectComputerCard(topCard);
    }

    // Method to collect cards from the table
    public void collectCards(CollectedCards collected) {
        if (!collected.isEmpty()) {
            collectedCards.addAll(collected.getCards());
            if (collected.isXeri()) {
                xeriCount++;
                if (collected.isXeriWithJacks()) {
                    xeriCount++;
                }
            }
        }
    }

    // Method to compute the points of the player's hand
    public void computePoints() {
        int collectedPoints = 0;
        for (Card card : collectedCards) {
            collectedPoints += card.getPoints();
        }
        points += collectedPoints;
    }

    // Method to compare the card count with another player
    public void compareCardCount(XeriPlayer otherPlayer) {
        if (collectedCards.size() > otherPlayer.collectedCards.size()) {
            points += 3;
        } else if (collectedCards.size() < otherPlayer.collectedCards.size()) {
            otherPlayer.points += 3;
        }
    }

    // Optional method to check if the hand is empty
    public boolean outOfCards() {
        return hand.isEmpty();
    }
}
