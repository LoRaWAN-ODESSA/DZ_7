package com.company;

public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(new A(5, 4), new B(4, 5), new C(2, 2));
        Triangle triangle2 = new Triangle(new A(2, 5), new B(2, 2), new C(4, 2));
        Triangle triangle3 = new Triangle(new A(0, 0), new B(2, 2), new C(2, 0));
        Triangle triangle4 = new Triangle(new A(1, 0), new B(5, 8), new C(7, 4));
        Triangle triangle5 = new Triangle(new A(0, 0), new B(0, 10), new C(5, 0));
        Triangle triangle6 = new Triangle(new A(1, 1), new B(5, 8), new C(7, 4));
        Triangle triangle7 = new Triangle(new A(1, 5), new B(2, 2), new C(4, 2));
        Triangle triangle8 = new Triangle(new A(-1, -5), new B(2, 2), new C(4, 2));
        Triangle triangle9 = new Triangle(new A(-1, -5), new B(6, 9), new C(15, 9));

        Triangle[] triangles = {triangle1, triangle2, triangle3, triangle4, triangle5, triangle6, triangle7, triangle8, triangle9};

        PrintParameters printParameters = new PrintParameters(triangles);
        printParameters.printInfo();
    }
}
