package StringRelatedQuestion;

public class StringManauplationQuestion {

	public static void main(String[] args) {

		String input = "1234567890";
		String output = "123****890";

		String output1 = input.substring(0, 3) + "****" + input.substring(input.length() - 3);
		
		System.out.println(output1);

	}

}
