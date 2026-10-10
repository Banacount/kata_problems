/*
 * ProblemId: 526571aae218b8ee490006f4 
 * Status: done
 *
 * */
import java.util.Scanner;

public class BitCounting {
	public static int countBits(int n){
		// Show me the code!
		String result = "";
		
		while (n > 0) {
			int r = n % 2;
			n /= 2;
			result = r + result;
		}

		int ans = 0;
		for (int i = 0; i < result.length(); ++i) {
			if (result.charAt(i) == '1') ans++;
		}

		return ans;
	}

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input: ");
		int parseIn = Integer.parseInt(input.nextLine());
		System.out.println(countBits(parseIn));
		input.close();
	}
}
