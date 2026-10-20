/*
 *
 * ProblemId: 51e056fe544cf36c410000fb
 * Status: not solved
 * 
 * */

import java.util.ArrayList;
import java.util.List;

public class TopWords {
    public static List<String> top3(String s) {
        List<String> result = new ArrayList<>();
        // Your code here
        String buf = "";
        for (int w = 0; w < s.length(); w++) {
            char let = s.charAt(w);

            if  (w+1 == s.length() && buf.length() > 0) {
                buf += let;
                System.out.println("This is a word fool: " + buf);
                continue;
            }

            if (let != ' ') {
                buf += let;
                continue;
            }

            System.out.println("This is a word fool: " + buf);
            buf = "";
        } 
        return result;
    }

    public static void main (String[] args) {
        top3("What the sigma");
    }
}
