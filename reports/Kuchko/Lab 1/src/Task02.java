package org.example;

public class Task02 {
    public static void main(String[] args) {
        double[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        double[] resultArray = flatten(array);
        for (double itr : resultArray) {
            System.out.print(itr + " ");
        }
    }

    static double[] flatten(double[][] array) {
        int arraySize = 0;
        for (double[] itr : array) {
            arraySize += itr.length;
        }
        double[] resultArray = new double[arraySize];
        int k = 0;
        for (double[] doubles : array) {
            for (double aDouble : doubles) {
                resultArray[k] = aDouble;
                k++;
            }
        }
        return resultArray;
    }
}
