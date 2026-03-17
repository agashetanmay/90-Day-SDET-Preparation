package SeleniumQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class selenium4NewFeature {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebElement emailAddressLabel = driver.findElement(By.id("lbl-email"));
		
	
		WebElement emailAddressField = driver.findElement( RelativeLocator.with(By.tagName("input")).near(emailAddressLabel));

	}

}
