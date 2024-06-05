// ILias Pierrakos , AM.4896

public class Xeri {
    public static void main(String[] args) {
        // Create players
        XeriPlayer userPlayer = new XeriPlayer("User");
        XeriPlayer computerPlayer = new XeriPlayer("Computer");

        // Create deck and pile
        CardStack deck = new CardStack();
        deck.shuffle();
        Pile pile = new Pile();
        pile.fill(deck);

        // Game loop
        while (!deck.isEmpty()) {
            
            Card topCard = pile.getTopCard();
            String topCardString = (topCard != null) ? topCard.toString() : "-";
            System.out.println("Top card of the pile: " + topCardString);

            // User player's turn
            Card userCard = userPlayer.selectCard();
            pile.drop(userCard);
            userPlayer.collectCards(pile.collect());
            userPlayer.computePoints();

            // Computer player's turn
            Card computerCard = computerPlayer.selectComputerCard(pile.getTopCard());
            pile.drop(computerCard);
            computerPlayer.collectCards(pile.collect());
            computerPlayer.computePoints();
        }

        // Compute final points
        userPlayer.compareCardCount(computerPlayer);

        // Print final points
        System.out.println("User points: " + userPlayer.getPoints());
        System.out.println("Computer points: " + computerPlayer.getPoints());

        // Determine winner
        if (userPlayer.getPoints() > computerPlayer.getPoints()) {
            System.out.println("User wins!");
        } else if (userPlayer.getPoints() < computerPlayer.getPoints()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
