package org.main;

/*
 * Problem_ID: 51b62bf6a9c58071c600001b
 * Status: unfinished
 */

public class Conversion {
    int[] numerals =        { 1,    5,   10,  50,  100, 500, 1000};
    char[] roman_letters =  {'I',  'V',  'X',  'L', 'C', 'D', 'M'};

    public String solution(int n) {
        String result = "";

        for (int i = numerals.length-1; i >= 0; --i) {
            int num_val = numerals[i];

            if (num_val <= n) {
                if (n < 10 && (n == 4 || n == 9)) {
                    result += roman_letters[0];
                    result += roman_letters[i];
                    n -= numerals[i]+1;
                } else {
                    result += roman_letters[i];
                    n -= numerals[i];
                }

                if (n > 0) i = numerals.length-1;
                else break;
            }
        }

        return result;
    }
}
