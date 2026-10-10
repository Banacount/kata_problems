/*
 * Problem ID: 515de9ae9dcfc28eb6000001
 * Status: Solved
*/

package org.main;

public class StringSplit {
    public static String[] solution(String s) {
        String buffer = "";
        String[] result;

        int result_size;
        if (s.length() % 2 != 0) result_size = (s.length()/2)+1;
        else result_size = s.length()/2;

        System.out.println(result_size);
        result = new String[result_size];

        int populated = 0;
        for (int i = 0; i < s.length(); ++i) {
            char letter = s.charAt(i); 
            buffer += letter;

            if (buffer.length() >= 2) {
                if (result[populated] == null) result[populated] = "";
                result[populated] += buffer;
                populated++; 
                buffer = "";
            }
        }

        if (buffer.length() == 1) {
            if (result[populated] == null) result[populated] = "";
            result[populated] += buffer + "_";
        }
        
        return result;
    }
}
