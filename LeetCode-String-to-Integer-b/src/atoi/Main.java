package atoi;

public class Main {
	public static void main(String[] args){
		String input = "42 wafa";
		
		System.out.println("input: " + input);
		
		System.out.println("Solution: " + myAtoi(input));
	}
	
	public static int myAtoi(String str) {
		int index = 0;
		int total = 0;
		int sign = 1;

		// Check if there is empty string
		if (str.length() == 0) {
			return 0;
		}

		// Remove white spaces
		while (index < str.length() && str.charAt(index) == ' ') {
			index++;
		}

		if (index == str.length()) {
			return 0;
		}

		// Handle the sign
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		// Convert to the actual number and avoid overflow
		while (index < str.length()) {
			int digit = str.charAt(index) - '0';

			if (digit < 0 || digit > 9) {
				break;
			}

			// check for overflow
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = total * 10 + digit;

			// increment the counter
			index++;
		}
		return total * sign;
	}
}
