public class Circle extends Shape{
    private double radius;

    // Constructor with the radius parameter
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter radius
    public double getRadius() {
        return radius;
    }

    // Setter radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateTheArea() {
        return Math.PI*(radius*radius);
    }

    @Override
    public double calculateThePerimeter() {
        return 2*Math.PI*radius;
    }
}
