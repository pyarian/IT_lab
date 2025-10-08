package week6;

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0.5 * base * height;
    }
}

class Rectangle extends Shape {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getArea() {
        return length * width;
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

public class assg02 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Triangle triangle = new Triangle(4.0, 3.0);
        Rectangle rectangle = new Rectangle(4.0, 5.0);
        Square square = new Square(4.0);

        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Square area: " + square.getArea());
    }
}