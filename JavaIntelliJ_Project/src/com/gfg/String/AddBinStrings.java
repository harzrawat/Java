package com.gfg.String;

public class AddBinStrings {
    public String addBinary(String s1, String s2) {
        // code here
        int idx1 = 0;
        while (idx1 < s1.length()){
            if (s1.charAt(idx1) == ' '){
                idx1++;
            }
        }
        int l = Math.min(s1.length(),s2.length());
        int i = 0;
        while (l-i-1==0){

            i++;
        }
        return "As";
    }

    public static void main(String[] args) {

    }
}
