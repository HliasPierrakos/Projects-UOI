// ILIAS PIERRAKOS , A.M.4896

public class Triangle extends Shape {
    public Triangle(int SquareArea) {
        super("Triangle", SquareArea);
    }

    public double computeArea() {
        return 0.5 * getSquareArea();
    }
}
