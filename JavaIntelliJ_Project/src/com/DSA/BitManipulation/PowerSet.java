package com.DSA.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(0, nums, new ArrayList<>(), new ArrayList<>());
    }
    public List<List<Integer>> subsets(int idx, int[] nums, List<List<Integer>> result, List<Integer> current) {
        if(idx>=nums.length){
//            System.out.println("idxin: "+idx);
            result.add(new ArrayList<>(current));
            return result;
        }

        current.add(nums[idx]);
//        System.out.println("1: "+current);
//        System.out.println("idx--: "+idx);
        subsets(idx+1, nums, result, current);      // when we are passing these parameter by changing, then we are passing the changed reference itself, so irrespectibvbe of method the variables are treated as global unless we call a new variable
//        System.out.println("idx1: "+idx);

        current.removeLast();
//        System.out.println("2: "+current);

        subsets(idx+1, nums, result, current);
//        System.out.println("idx2: "+idx);

        return result;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4};
        PowerSet obj1 = new PowerSet();

        System.out.println(obj1.subsets(a));
    }
}
