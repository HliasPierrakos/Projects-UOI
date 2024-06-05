// ILIAS PIERRAKOS , A.M.4896

public abstract class Shape {
    private String type;
    private int SquareArea;

    public Shape(String type, int SquareArea) {
        this.type = type;
        this.SquareArea = SquareArea;
    }

    public abstract double computeArea();

    public double computePoints() {
        return computeArea();
    }

    public boolean sameArea(Shape other) {
        return this.computeArea() == other.computeArea();
    }

    public boolean sameType(Shape other) {
        return this.type.equals(other.type);
    }

    public String toString() {
        return type + " with square area " + SquareArea;
    }

    public int getSquareArea() {
        return SquareArea;
    }
}
