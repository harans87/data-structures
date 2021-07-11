package com.mytrial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintSubArray {

    public static void main(String[] args) {
        int[] input = { 4, 2, -3, -1, 0, 4 };
        if (input.length == 0) {
            System.out.println("Array input is empty");
        }
        printSubArray(input);

    }

    public static void printSubArray(int[] input) {
        int length = input.length;
        int sum = 0;
        HashMap<Integer, List<Integer>> subArrayMap = new HashMap<>();
        insertIntoMap(subArrayMap, 0, -1);
        for (int i=0;i<length;i++) {
            sum += input[i];
            if (subArrayMap.get(sum) != null) {
                System.out.println("Subarray -->"+subArrayMap.get(sum));
            }
            insertIntoMap(subArrayMap, sum, i);
        }
    }

    public static void insertIntoMap(HashMap<Integer, List<Integer>> subArrayMap,
    int sum, int i) {
        subArrayMap.putIfAbsent(sum, new ArrayList<>());
        subArrayMap.get(sum).add(i);
    }

    
    
}
