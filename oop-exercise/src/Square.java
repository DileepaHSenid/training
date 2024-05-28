public class Square extends Shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Getter and the setter
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculateTheArea() {
        return side*side;
    }

    @Override
    public double calculateThePerimeter() {
        return side*4;
    }
}
