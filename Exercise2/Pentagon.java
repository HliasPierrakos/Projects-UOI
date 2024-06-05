// ILIAS PIERRAKOS , A.M.4896

public class Pentagon extends Shape {
    public Pentagon(int SquareArea) {
        super("Pentagon", SquareArea);
    }

    public double computeArea() {
        return 0.75 * getSquareArea();
    }
}
