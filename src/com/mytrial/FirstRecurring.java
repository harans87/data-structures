package com.mytrial;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurring {

    public static void main(String[] args) {
        // O (n) - time, O(n) - space - worst case
        int[] input = {1,7,8,1,10,20};
        int length = input.length;
        // int i = 0;
        // int j = length - 1;
        // int first = input[i];
        // int last = input[j];

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i<length;i++) {
            if (hashMap.get(input[i]) != null) {
                System.out.println("first recurring -->"+input[i]);
            }
            hashMap.put(input[i], i);
        }
        // while (i < length && j >= 0) {
        //     if (first == last) {
        //         System.out.println("first recurring character"+first);
        //         break;
        //     }
        //     last = input[j--];

        // }
        // System.out.println("No recurring character");

    }
    
}
