package com.mytrial;

import java.util.ArrayList;

public class MoveZeros {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int[] nums = {0,1,0,3,12};
        int length = nums.length;
        int i = 0;
        while (i < length-1) {
            if (nums[i] == 0 && nums[i+1] != 0) {
                nums[i] = nums[i+1];
                nums[i+1] = 0;
            }
            if (nums[i] == 0 && nums[i+1] == 0) {
                nums[i] = nums[i+2];
            }
            i++;
        }
        System.out.println("nums -->"+nums.toString());
    }
    
}
