// ILias Pierrakos , AM.4896

import java.util.Random;

public class CardStack {
    private Card[] cards;
    private int top;
    private int currentSize;
    private final int TOTAL_CARDS = 52;

    // Constructor to create a stack with one deck of cards
    public CardStack() {
        cards = new Card[TOTAL_CARDS];
        top = -1;
        currentSize = 0;
        // Create one deck of cards
        for (int i = 2; i <= 14; i++) {
            for (String suit : new String[]{"S", "H", "D", "C"}) {
                cards[currentSize++] = new Card(suit, i);
            }
        }
    }

    // Constructor to create a stack with multiple decks of cards
    public CardStack(int numDecks) {
        cards = new Card[TOTAL_CARDS * numDecks];
        top = -1;
        currentSize = 0;
        // Create multiple decks of cards
        for (int j = 0; j < numDecks; j++) {
            for (int i = 2; i <= 14; i++) {
                for (String suit : new String[]{"S", "H", "D", "C"}) {
                    cards[currentSize++] = new Card(suit, i);
                }
            }
        }
    }

    // Method to shuffle the cards in the stack
    public void shuffle() {
        Random random = new Random();
        for (int i = currentSize - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }

    // Method to draw and return the top card from the stack
    public Card draw() {
        if (isEmpty()) {
            return null;
        }
        return cards[top--];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is half empty
    public boolean isHalfEmpty() {
        return top < (currentSize / 2);
    }

    // Method to return a string representation of the stack
    public String toString() {
        String result = "";
        for (int i = 0; i <= top; i++) {
            result += cards[i].toString() + " ";
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a stack with one deck of cards
        CardStack stack1 = new CardStack();
        System.out.println("Stack with one deck of cards:");
        System.out.println(stack1);
        Card card1 = stack1.draw();
        Card card2 = stack1.draw();
        System.out.println("Drawn cards: " + card1 + ", " + card2);
        System.out.println("Stack after drawing: ");
        System.out.println(stack1);

        // Create a stack with two decks of cards
        CardStack stack2 = new CardStack(2);
        System.out.println("\nStack with two decks of cards:");
        System.out.println(stack2);
        stack2.shuffle();
        System.out.println("Stack after shuffling: ");
        System.out.println(stack2);

        // Draw cards until finding a pair or the stack is half empty
        System.out.println("\nDrawing cards until finding a pair or the stack is half empty:");
        while (!stack2.isEmpty() && !stack2.isHalfEmpty()) {
            Card drawnCard1 = stack2.draw();
            Card drawnCard2 = stack2.draw();
            System.out.println("Drawn cards: " + drawnCard1 + ", " + drawnCard2);
        }
        System.out.println("Stack after drawing: ");
        System.out.println(stack2);
    }
}
