// ILIAS PIERRAKOS , A.M.4896

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeGenerator {
    private List<Shape> shapes;
    private int curIndex;

    public ShapeGenerator(int numberOfShapesPerType) {
        shapes = new ArrayList<>();
        initializeShapes(numberOfShapesPerType);
        shuffleShapes();
        curIndex = 0;
    }

    private void initializeShapes(int numberOfShapesPerType) {
        int[] possibleSizes = {1, 2, 3, 4, 8, 12, 16};
        Random random = new Random();

        for (int i = 0; i < numberOfShapesPerType; i++) {
            for (int size : possibleSizes) {
                shapes.add(new Square(size));
                shapes.add(new Triangle(size));
                shapes.add(new Pentagon(size));
                shapes.add(new Circle(size));
                shapes.add(new BonusCircle(size, random.nextInt(10) + 1));
            }
        }
    }

    private void shuffleShapes() {
        Random random = new Random();
        for (int i = shapes.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Shape temp = shapes.get(index);
            shapes.set(index, shapes.get(i));
            shapes.set(i, temp);
        }
    }

    public Shape nextShape() {
        if (curIndex < shapes.size()) {
            return shapes.get(curIndex++);
        }
        return null;
    }

    public boolean hasShape() {
        return curIndex < shapes.size();
    }

    public String toString() {
        String result = "";
        for (Shape shape : shapes) {
            result += shape.toString() + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        ShapeGenerator generator = new ShapeGenerator(2);
        while (generator.hasShape()) {
            Shape shape = generator.nextShape();
            System.out.println("Next shape: " + shape);
            System.out.println("Remaining shapes: \n" + generator);
        }
    }
}

