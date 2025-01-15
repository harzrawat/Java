package com.gfg;

// Approach: let array be {a, b, c, .... , e, f} is sorted in asc.
// then max tower height can be --> a+k, b+k, c+k, d+k, .... , e+k, f-k}
// and min tower height can be --> a+k, b-k, c-k, d-k,.... ,e-k,f-k}
// here we traverse through the array and consider min(c-k,a+k) as the smallest then we choose max(b+k,f-k) as the greatest num, this is so bcz b+k is greater then previous
// arr[i] : but what is we transform it as b-k and consider max(a+k,f-k) then: here we don't do so bcz in this case when we do transformation for b it will be either b-k
// (smaller than c-k ) or b+k (greater than a+k) hence considering this case makes no sense.
// 2nd question here arises that why don't we consider max(d+k,f-k) in case b+k is not greater than c-k: in this case f-k will be greater, but if we consider max(d+k,f-k) then
// in that case e-k can be minimum for max(d+k,f-k) giving smaller difference as e-k is greater than b-k

import java.util.ArrayList;
import java.util.Arrays;

public class HeightMinimize {
    int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int minDiff = arr[arr.length-1]-arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]-k < 0){
                continue;       // bcz the transformation shouldn't bring -ve number
            }
            int maxH = Math.max(arr[i-1]+k,arr[arr.length-1]-k);
            System.out.println("maxH: "+maxH);
            int minH = Math.min(arr[i]-k,arr[0]+k);
            System.out.println("minH: "+ minH);
            minDiff = Math.min(minDiff,maxH-minH);
            System.out.println(minDiff);
        }
        return  minDiff;
    }
    public static void main(String[] args) {
//        int k = 2;
//        int[] arr = {1, 5, 8, 10};
        int k = 3;
        int[] arr = {3, 5};


        HeightMinimize obj1 = new HeightMinimize();
        System.out.println(obj1.getMinDiff(arr, k));
    }
}





























