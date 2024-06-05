// ILias Pierrakos , AM.4896

public class BetweenPlayer {
    private int money; 

    
    public BetweenPlayer(int initialMoney) {
        this.money = initialMoney;
    }

    // This method it is for player bid
    public int bid(int pot) {
        System.out.println("Pot: " + pot + ", Your Money: " + money);
        System.out.print("Enter your bid: ");
        
        Scanner scanner = new Scanner(System.in);
        int bidAmount = scanner.nextInt();
        
        bidAmount = Math.min(bidAmount, money);
        bidAmount = Math.min(bidAmount, pot);
        return bidAmount;
    }

    // Add money to player
    public void addMoney(int amount) {
        this.money += amount;
    }

    // Substract money from pleyr
    public void subtractMoney(int amount) {
        this.money -= amount;
    }

    // Check if player is out of money
    public boolean isBroke() {
        return money <= 0;
    }
}
