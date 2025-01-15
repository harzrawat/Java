package com.gfg.Contest;

// an array is good if the length of arr is even and we can divide the array into n/2 pairs such that bitwise XOR for each pair is k
// output will be to give minimum number of elements to append into array to make it good

// 3,1,7,9,12,6,3 :-
public class GoodArray {
    public int goodArray(int[] arr, int k){
        int l = arr.length;
        int step = 1;
        if (l%2!=0){
            step = 2;
        }
        return 1;
    }
    public static void main(String[] args) {
        int a = 13;
        int b = ~(1<<2);
        System.out.println(b);
    }
}
