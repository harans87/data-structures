package com.mytrial;
import java.util.Arrays;

public class ReverseString2 {
    public static void main(String args[]) {
        String inputString = "hi my name is yashicaa";
        if (inputString.isBlank()) {
            System.out.println("Input string is null or empty");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inputString);
        stringBuilder.reverse();
        System.out.println("Reversed String -->"+stringBuilder);
    }
    
}
