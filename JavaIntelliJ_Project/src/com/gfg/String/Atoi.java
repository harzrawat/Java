package com.gfg.String;
// there will be a given string from which we have to extract out the first occuring number with the instant symbol
// approach will be according to following steps:
//Skip any leading whitespaces.
//Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
//Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
//If the integer is greater than 2**31 – 1, then return 2**31 – 1 and if the integer is smaller than -2**31, then return -2**31.
public class Atoi {
    public int myAtoi(String s) {
        // Your code here
        int num = 0;
        int sign = 1;
        int i = 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        // checking for symbol if any
        if (i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if (s.charAt(i)=='-'){
                sign = -1;
            }
            i++;
        }
        while (i<s.length() && Character.isDigit(s.charAt(i))){
            if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && sign==-1)){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num*10 + (s.charAt(i) - '0');
            i++;
        }
        return sign*num;

    }
    public static void main(String[] args) {
        String s = "1231231231311133";
        Atoi obj1 = new Atoi();
        System.out.println(obj1.myAtoi(s));

    }
}
