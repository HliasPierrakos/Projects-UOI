// ILIAS PIERRAKOS , A.M.4896

import java.util.Scanner;

public class ShapeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please fill in the number of shapes: ");
        int numberOfShapesPerType = scanner.nextInt();

        System.out.print("Fill in the maximum stack size it will have: ");
        int maxStackSize = scanner.nextInt();

        ShapeGenerator generator = new ShapeGenerator(numberOfShapesPerType);
        Player player = new Player(maxStackSize);

        while (generator.hasShape() && !player.isStackFull()) {
            System.out.println("\nCurrent stack:");
            player.printStack();

            Shape shape = generator.nextShape();
            player.playShape(shape);

            System.out.println("Current points: " + player.getPoints());
        }

        System.out.println("\nGame over! Total points: " + player.getPoints());
        scanner.close();
    }
}
