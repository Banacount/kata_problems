package org.main;

/*
 * Problem_ID: 51b62bf6a9c58071c600001b
 * Status: done
 */

public class Conversion {
    class Pair {
        int num;
        String str;

        Pair (int value, String roman) {
            this.num = value;
            this.str = roman;
        }
    }

    public String solution(int n) {
        Pair[] romans = {
            new Pair(1000, "M"),
            new Pair(900, "CM"),
            new Pair(500, "D"),
            new Pair(400, "CD"),
            new Pair(100, "C"),
            new Pair(90, "XC"),
            new Pair(50, "L"),
            new Pair(40, "XL"),
            new Pair(10, "X"),
            new Pair(9, "IX"),
            new Pair(5, "V"),
            new Pair(4, "IV"),
            new Pair(1, "I"),
        };

        String result = "";

        for (Pair pair : romans) {
            int cur = pair.num;

            while (n >= cur) {
                result += pair.str;
                n -= cur;
            }
        }

        return result;
    }
}
