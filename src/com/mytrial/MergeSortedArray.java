package com.mytrial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int [] array2 = {3, 4, 5, 6}; // O(n)
        if (array1.length == 0) {
            System.out.println("Merged Array --> "+array2);
        }

        if (array2.length == 0) {
            System.out.println("Merged Array --> "+array1);
        }
        // output is {1,2,3,3,4,4,5,6};
        List<Integer> integerList = new ArrayList<>();
        for (int i=0; i<array1.length; i++) { // O(n)
            integerList.add(array1[i]);
        }

        for (int j=0;j<array2.length;j++) { // O(n)
            integerList.add(array2[j]);
        }

        List<Integer> sortedArray = 
        integerList.stream().sorted().collect(Collectors.toList());

        System.out.println("Merged Array -->"+sortedArray);
    }
}