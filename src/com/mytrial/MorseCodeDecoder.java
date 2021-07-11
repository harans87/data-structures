package com.mytrial;


public class MorseCodeDecoder {
    public static void main(String args[]) {
        String morseCode = ".... . -.--   .--- ..- -.. .";
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = morseCode.split("\\s\\s\\s");

        for (String word: words) {
            stringBuilder.append(MorseCode.get(word));
        }

       
        System.out.println(stringBuilder);

        
      
        // return stringBuilder.toString();
    }
}

