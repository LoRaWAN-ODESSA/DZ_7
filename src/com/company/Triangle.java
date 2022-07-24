package com.company;

public class Triangle {

    private A a;
    private B b;
    private C c;
    private double lengthA;
    private double lengthB;
    private double lengthC;
    private double angleA;
    private double angleB;
    private double angleC;
    private boolean isEquilateral = false;
    private boolean isIsosceles = false;
    private boolean isRight = false;
    private boolean isScalene = false;
    private double perimeter;
    private double area;

    public Triangle(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
        findLengths();
        findAngles();
        findType();
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    private void findLengths() {
        lengthA = Math.sqrt(Math.pow(b.getY() - a.getY(), 2) + Math.pow(b.getX() - a.getX(), 2));
        lengthB = Math.sqrt(Math.pow(b.getY() - c.getY(), 2) + Math.pow(c.getX() - b.getX(), 2));
        lengthC = Math.sqrt(Math.pow(c.getY() - a.getY(), 2) + Math.pow(c.getX() - a.getX(), 2));
    }

    private void findAngles() {
        angleA = (Math.pow(lengthA, 2) + Math.pow(lengthC, 2) - Math.pow(lengthB, 2)) / (2 * lengthA * lengthC);
        angleB = (Math.pow(lengthA, 2) + Math.pow(lengthB, 2) - Math.pow(lengthC, 2)) / (2 * lengthA * lengthB);
        angleC = (Math.pow(lengthB, 2) + Math.pow(lengthC, 2) - Math.pow(lengthA, 2)) / (2 * lengthC * lengthB);
    }

    private void findType() {
        if (lengthA == lengthB && lengthB == lengthC) {
            isEquilateral = true;
            return;
        } else if (Math.cos(angleA) == 1 || Math.cos(angleB) == 1 || Math.cos(angleC) == 1) {
            isRight = true;
            return;
        } else if (lengthA == lengthB || lengthA == lengthC || lengthB == lengthC) {
            isIsosceles = true;
        } else {
            isScalene = true;
        }
    }

    private double calculatePerimeter() {
        return lengthA + lengthB + lengthC;
    }

    private double calculateArea() {
        return 0.25 * (Math.sqrt((lengthA + lengthB - lengthC) * (lengthA - lengthB + lengthC) * (lengthB - lengthA + lengthC) * (lengthA + lengthB + lengthC)));
    }

    public boolean isEquilateral() {
        return isEquilateral;
    }

    public boolean isIsosceles() {
        return isIsosceles;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isScalene() {
        return isScalene;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
