package com.mytrial;
import java.util.ArrayList;
import java.util.List;

public class ReverseString {
    public static void main (String args[]) {
        String inputString = "hi my name is yashicaa";
        if (null == inputString ||inputString.length() == 0) {
            System.out.println("Input string is null or empty");
        }
        char[] input = inputString.toCharArray();
        List<Character> characterList = new ArrayList<>(); // extra space of O(n)
        for (int i=input.length-1; i >=0; i--) { // time complexity of O(n)
            characterList.add(input[i]);
        }
        System.out.println("Reversed string -->" +characterList.toString());
    }
}