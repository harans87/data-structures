package com.mytrial;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortBinaryArray {

    public static void main(String[] args) {
        int[] input = { 1, 0, 1, 0, 1, 0, 0, 1 };
        // List<Integer> finalOutput = Arrays.stream(input)
        // .sorted().boxed().collect(Collectors.toList());
        int countOfZeros = 0;
        for (int value: input) {
            if (value == 0) {
                countOfZeros++;
            }
        }
        int k=0;
        while (countOfZeros-- !=0) {
            input[k++] = 0;
        }

        while (k < input.length) {
            input[k++] = 1;
        }
        System.out.println("Sorted Binary Array -->"+Arrays.toString(input));
    }
    
}
