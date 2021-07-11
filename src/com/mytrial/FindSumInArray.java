package com.mytrial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindSumInArray {

    public static void main(String args[]) {
        int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        List<String> arrayList = new ArrayList<>();
        if (numbers.length == 0)
            System.out.println("empty numbers");
        // StringBuilder stringBuilder = new StringBuilder();
        // for (int i = 0; i < numbers.length; i++) {
        //     if (i == 0) {
        //         stringBuilder.append("(");
        //     }
        //     if (i == 3) {
        //         stringBuilder.append(") ");
        //     }

        //     if (i == 6) {
        //         stringBuilder.append("-");
        //     }

        //     stringBuilder.append(String.valueOf(numbers[i]));
        // }

        // // for (String num: numbersList) {
        //     System.out.println(stringBuilder.toString());
        // // }

        System.out.println(Arrays.stream(numbers)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining())
        .replaceFirst("^(\\d{3})(\\d{3})(\\d{4})$", "($1) $2-$3"));
        
    }
}
