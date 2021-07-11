package com.mytrial;

import java.util.Arrays;
import java.util.List;

public class ConvertFive {
    public static void main(String[] args) {
        int input = 1005;
        int result = convertfive(1005);
        System.out.println("final result -->"+result);
    }

    static int convertfive(int num) {
        if (num == 0)
            return 5;
        else
            return convertfiveRec(num);
    }

    static int convertfiveRec(int num) {
        // Base case for recursion termination
        if (num == 0) return 0;

        // Extract the last digit and change it if needed
        int digit = num % 10;
        if (digit == 0) digit = 5;

        // Convert remaining digits and append the last digit
        return convertfiveRec(num / 10) * 10 + digit;
    }
}
