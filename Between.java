// ILias Pierrakos , AM.4896

import java.util.Scanner;

// The main class where implements the game
public class Between {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter money for the dealer: ");
        int dealerMoney = scanner.nextInt();
        System.out.print("Enter money for the player: ");
        int playerMoney = scanner.nextInt();
       
        BetweenDealer dealer = new BetweenDealer(dealerMoney);
        BetweenPlayer player = new BetweenPlayer(playerMoney);

        
        while (!dealer.emptyPot() && !player.isBroke()) {
            dealer.play(player);
        }

        
        if (dealer.emptyPot()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
    close scanner;
}
