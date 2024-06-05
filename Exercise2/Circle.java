// ILIAS PIERRAKOS , A.M.4896

public class Circle extends Shape {
    public Circle(int SquareArea) {
        super("Circle", SquareArea);
    }

    public double computeArea() {
        return 3.14 * 0.25 * getSquareArea();
    }
}
