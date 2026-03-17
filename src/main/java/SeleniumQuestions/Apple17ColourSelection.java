package SeleniumQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Apple17ColourSelection {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.apple.com/in/iphone-17/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50L));
		WebElement colourButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='control-color--button']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behaviour:'smooth',block:'center'})", colourButton);

		WebElement colourButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='control-color--button']")));
		colourButton1.click();

		List<WebElement> colourList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath("//li[@id='color-selector']/child::div[@class='control-item-content']//fieldset/ul/li/label")));

		for (WebElement colour : colourList) {

			String colourname = colour.getAttribute("for");

			if (colourname.toLowerCase().contains("green")) {

				colour.click();
				System.out.println(colourname);

				WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@class='controls']/ul/li[@id='color-selector']//p[contains(@class,'typography')]")));
				
		  if(text.getText().toLowerCase().contains("sage")) {
			  
			  System.out.println(true);
		  }
		  else {
			  System.out.println(false);
		  }

			}

		}

	}

}
