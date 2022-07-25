package com.company;

public class PrintParameters {

    private Triangle[] triangles;
    private String[] categories = {"Equilateral: ", "Isosceles: ", "Right: ", "Scalene: "};
    private int[] typeList;
    private int[] typeNumber;

    public PrintParameters(Triangle[] triangles) {
        this.triangles = triangles;
        typeList = findTypesNumber();
        typeNumber = calculateTypes();
    }

    public void printInfo() {
        printTypesNumber();
        printComparison();
    }

    private void printTypesNumber() {
        System.out.println("The list of triangles by types:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(categories[i] + typeNumber[i]);
        }
        System.out.println();
    }

    private void printComparison() {
        double maxPerimeter = 0;
        double minPerimeter = 0;
        double maxArea = 0;
        double minArea = 0;
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

    private int[] findTypesNumber() {
        typeNumber = new int[triangles.length];
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

    private int[] calculateTypes() {
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
