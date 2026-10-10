
/*
 * Problem Id: 517abf86da9663f1d2000003
 * status: done
*/

import java.lang.StringBuilder;
import java.util.Scanner;

class Solution{

  static String toCamelCase(String s){
    String result = "";

    Boolean did = false;
    for (int i = 0; i < s.length(); ++i) {
      char cur = s.charAt(i);
      Boolean can = true;

      if (did) {
        result += Character.toUpperCase(cur);
        can = false;
      }

      if (cur == '_' || cur == '-') {
        did = true;
        can = false;
      } else {
        did = false;
      }

      if (can) result += cur;
    }

    return result;
  }
}

public class ToCamelCase {
  public static void main (String[] args) {
    Solution sol = new Solution();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter input: ");
    System.out.println(sol.toCamelCase(input.nextLine()));
  }
}
