// ILIAS PIERRAKOS , A.M.4896

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Shape> stack;
    private int points;

    public Player(int stackSize) {
        stack = new ArrayList<>(stackSize);
        points = 0;
    }

    public void playShape(Shape shape) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New shape: " + shape);
        System.out.print("Do you want to keep this shape? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        
        if (response.equals("yes")) {
            double shapePoints = shape.computePoints();

            if (!stack.isEmpty()) {
                Shape topShape = stack.get(stack.size() - 1);
                if (shape.sameArea(topShape)) {
                    shapePoints *= 10;
                }
                if (shape.sameType(topShape)) {
                    stack.remove(stack.size() - 1);
                    System.out.println("Removed top shape from stack (same type).");
                } else {
                    stack.add(shape);
                }
            } else {
                stack.add(shape);
            }

            points += shapePoints;
            System.out.println("Points earned: " + shapePoints);
            System.out.println("Total points: " + points);
        } else {
            System.out.println("Shape discarded.");
        }
        scanner.close();
    }

    public boolean isStackFull() {
        return stack.size() == stack.capacity();
    }

    public void printStack() {
        for (Shape shape : stack) {
            System.out.println(shape);
        }
    }

    public int getPoints() {
        return points;
    }
}
