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
        printTypesNumber(triangles);
        printComparison(triangles);
    }

    public static void printTypesNumber(Triangle[] triangles) {
        int[] typeList = calculateTypes(triangles);
        System.out.println("The list of triangles by types:");
        System.out.println("Equilateral: " + typeList[0]);
        System.out.println("Isosceles: " + typeList[1]);
        System.out.println("Right: " + typeList[2]);
        System.out.println("Scalene: " + typeList[3] + "\n");
    }

    public static void printComparison(Triangle[] triangles) {
        double maxPerimeter = 0;
        double minPerimeter = 0;
        double maxArea = 0;
        double minArea = 0;
        String[] categories = {"Equilateral:", "Isosceles:", "Right:", "Scalene:"};
        int[] typeList = findTypesNumber(triangles);
        int[] typeNumber = calculateTypes(triangles);
        System.out.println("The list of comparison triangles by perimeter and area by types:");
        for (int i = 0; i < typeNumber.length; i++) {
            System.out.println(categories[i]);
            if (typeNumber[i] == 0) {
                System.out.println("No triangles were found!");
            } else if (typeNumber[i] == 1) {
                for (int j = 0; j < triangles.length; j++) {
                    if (typeList[j] == i + 1) {
                        maxPerimeter = triangles[j].getPerimeter();
                        System.out.print("We have found just 1 triangle (triangle" + (j + 1) + ") with perimeter: " + Math.round(maxPerimeter) + " ");
                        maxPerimeter = 0;
                        maxArea = triangles[j].getArea();
                        System.out.println("and area: " + Math.round(maxArea));
                        maxArea = 0;
                    }
                }
            } else {
                for (int j = 0; j < triangles.length; j++) {
                    if (typeList[j] == i + 1) {
                        minPerimeter = triangles[j].getPerimeter();
                        minArea = triangles[j].getArea();
                        break;
                    }
                }
                int numMaxPerimeter = 0;
                int numMinPerimeter = 0;
                int numMaxArea = 0;
                int numMinArea = 0;
                for (int j = 0; j < triangles.length; j++) {
                    if (typeList[j] == i + 1) {
                        if (triangles[j].getPerimeter() > maxPerimeter) {
                            maxPerimeter = triangles[j].getPerimeter();
                            numMaxPerimeter = j + 1;
                        }
                        if (minPerimeter > triangles[j].getPerimeter()) {
                            minPerimeter = triangles[j].getPerimeter();
                            numMinPerimeter = j + 1;
                        }
                        if (triangles[j].getArea() > maxArea) {
                            maxArea = triangles[j].getArea();
                            numMaxArea = j + 1;
                        }
                        if (minArea > triangles[j].getArea()) {
                            minArea = triangles[j].getArea();
                            numMinArea = j + 1;
                        }
                    }
                }
                System.out.println("The max perimeter of triangle (triangle" + numMaxPerimeter + ") this type is: " + Math.round(maxPerimeter));
                System.out.println("The min perimeter of triangle (triangle" + numMinPerimeter + ") this type is: " + Math.round(minPerimeter));
                System.out.println("The max area of triangle (triangle" + numMaxArea + ") this type is: " + Math.round(maxArea));
                System.out.println("The min area of triangle (triangle" + numMinArea + ")this type is: " + Math.round(minArea));
                maxPerimeter = 0;
                minPerimeter = 0;
                maxArea = 0;
                minArea = 0;
                numMaxPerimeter = 0;
                numMinPerimeter = 0;
                numMaxArea = 0;
                numMinArea = 0;
            }
        }
    }

    private static int[] findTypesNumber(Triangle[] triangles) {
        int[] typeNumber = new int[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isEquilateral()) {
                typeNumber[i] = 1;
            } else if (triangles[i].isIsosceles()) {
                typeNumber[i] = 2;
            } else if (triangles[i].isRight()) {
                typeNumber[i] = 3;
            } else if (triangles[i].isScalene()) {
                typeNumber[i] = 4;
            }
        }
        return typeNumber;
    }

    private static int[] calculateTypes(Triangle[] triangles) {
        int[] typeNumber = findTypesNumber(triangles);
        int[] result = {0, 0, 0, 0};
        for (int i = 0; i < typeNumber.length; i++) {
            if (typeNumber[i] == 1) {
                result[0]++;
            } else if (typeNumber[i] == 2) {
                result[1]++;
            } else if (typeNumber[i] == 3) {
                result[2]++;
            } else if (typeNumber[i] == 4) {
                result[3]++;
            }
        }
        return result;
    }
}
