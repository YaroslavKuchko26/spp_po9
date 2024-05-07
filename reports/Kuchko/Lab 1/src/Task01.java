package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        int sum = 0;
        for (String itr : args) {
            int curr = Integer.parseInt(itr);
            array.add(curr);
            sum += curr;
        }

        double average = (double) sum / args.length;
        int outlier = array.get(0);

        for (int itr : array) {
            if (Math.abs(itr - average) > Math.abs(outlier - average)) {
                outlier = itr;
            }
        }
        System.out.println(outlier);
    }
}
