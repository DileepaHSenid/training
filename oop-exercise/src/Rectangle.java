public class Rectangle extends Shape {
    private double length;
    private double height;

    // Constructor
    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    // Getters and the setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateTheArea() {
        return height*length;
    }

    @Override
    public double calculateThePerimeter() {
        return 2*(height+length);
    }
}
