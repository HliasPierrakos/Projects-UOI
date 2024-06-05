// ILIAS PIERRAKOS , A.M.4896

public class BonusCircle extends Circle {
    private int bonus;

    public BonusCircle(int SquareArea, int bonus) {
        super(SquareArea);
        this.bonus = bonus;
    }

    public double computePoints() {
        return super.computePoints() + bonus;
    }

    public String toString() {
        return super.toString() + " (bonus: " + bonus + ")";
    }
}
