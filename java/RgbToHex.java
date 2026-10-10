package org.main;

public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        String result = "";

        result += RgbToHex.toHex(r);
        result += RgbToHex.toHex(g);
        result += RgbToHex.toHex(b);
        
        return result;
    }

    public static String toHex(int value) {
        String ans = "";

        if (value > 255) return "FF";

        int s1 = value / 16, s2 = value % 16;

        s1 = RgbToHex.min_max(s1, 0, 15);
        s2 = RgbToHex.min_max(s2, 0, 15);

        if (s1 > 9) ans += (char)((s1-10) + 65);
        else ans += s1;
        if (s2 > 9) ans += (char)((s2-10) + 65);
        else ans += s2;

        return ans;
    }

    public static int min_max (int value, int min, int max) { 
        return (value > max ? max : (value < min ? min : value)); 
    }
}

