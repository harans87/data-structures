package com.mytrial;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCommonInArrays {
    public static void main(String[] args) throws Exception {
        char[] array1 = {'a','b', 'c','d'};
        char[] array2 = {'e','f', 'a'};
        Set<Character> commonChara = new HashSet<>();

        // put array1 elements into hash set
        for(int i=0;i< array1.length; i++) {
            commonChara.add(array1[i]);
        }

        // iterate array2 and see if any element is persent in hashset
        for(int j=0; j< array2.length; j++) {
         System.out.println(array2[j]+"is present --->"+!commonChara.add(array2[j]));
        }
        // O(a + b) - time
        // space - O(a) - extra space

        // boolean result = Arrays.asList(array1).stream()
        // .anyMatch(arr -> Arrays.asList(array2).indexOf(arr) < 0);
        // System.out.println("Element is present -->"+result);
    }
}
