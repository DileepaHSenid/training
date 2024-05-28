import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu(); // Print the menu options
            try {
                int input = scanner.nextInt(); // Read user input inside the loop
                switch (input) {
                    case 1:
                        System.out.print("Enter the Length - ");
                        double length = scanner.nextDouble(); // Read length input
                        System.out.print("Enter the Height - ");
                        double height = scanner.nextDouble(); // Read height input
                        printOutput("Rectangle", height, length); // Call printOutput for Rectangle
                        break;
                    case 2:
                        System.out.print("Enter the Length of a side - ");
                        double side = scanner.nextDouble(); // Read side input
                        printOutput("Square", side, side); // Call printOutput for Square
                        break;
                    case 3:
                        System.out.print("Enter the radius - ");
                        double radius = scanner.nextDouble(); // Read radius input
                        printOutput("Circle", radius, radius); // Call printOutput for Circle
                        break;
                    case 4:
                        System.out.println("Done!");
                        return; // Exit the program
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) { // Catch InputMismatchException
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    public static void printMenu() {
        System.out.println(" -- Select the Shape -- ");
        System.out.println("(1) Rectangle");
        System.out.println("(2) Square");
        System.out.println("(3) Circle");
        System.out.println("(4) Exit");
        System.out.println();
        System.out.print("Enter Your choice - ");
        System.out.println();
    }

    public static void printOutput(String shape, double heightOrSide, double lengthOrRadius) {
        System.out.println("Shape: " + shape); // Print shape name
        System.out.println("Properties:");
        if (shape.equals("Rectangle")) { // Check if shape is Rectangle
            System.out.println("Height: " + heightOrSide); // Print height
            System.out.println("Length: " + lengthOrRadius); // Print length
            Rectangle rectangle = new Rectangle(lengthOrRadius, heightOrSide); // Create Rectangle object
            double perimeter = rectangle.calculateThePerimeter(); // Calculate perimeter
            double area = rectangle.calculateTheArea(); // Calculate area
            System.out.println("Perimeter: " + perimeter); // Print perimeter
            System.out.println("Area: " + area); // Print area
        } else if (shape.equals("Square")) { // Check if shape is Square
            System.out.println("Side: " + heightOrSide); // Print side
            Square square = new Square(heightOrSide); // Create Square object
            double perimeter = square.calculateThePerimeter(); // Calculate perimeter
            double area = square.calculateTheArea(); // Calculate area
            System.out.println("Perimeter: " + perimeter); // Print perimeter
            System.out.println("Area: " + area); // Print area
        } else { // If shape is Circle
            System.out.println("Radius: " + lengthOrRadius); // Print radius
            Circle circle = new Circle(lengthOrRadius); // Create Circle object
            double perimeter = circle.calculateThePerimeter(); // Calculate perimeter
            double area = circle.calculateTheArea(); // Calculate area
            System.out.println("Perimeter: " + perimeter); // Print perimeter
            System.out.println("Area: " + area); // Print area
        }
    }
}
