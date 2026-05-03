package SeleniumQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class try_catchBlock {

	public static void main(String[] args) {


		try {
			System.out.println("A");
			
			int value = 99/0;
			
			System.out.println("B");
		}
		catch(ArithmeticException e) {
			
			System.out.println("D");
			
		}
		catch (RuntimeException e) {
			System.out.println("G");
		}
		
		finally {
			
			System.out.println("F");
			
		}

	}

}
