package StringRelatedQuestion;

public class StringFormat {

	public static void main(String[] args) {
	
		String myStr = "Hello %s! One kilobyte is %d %s";
		String result = String.format(myStr, "World", 1024,"byte");
		System.out.println(result);

	}
	

}
