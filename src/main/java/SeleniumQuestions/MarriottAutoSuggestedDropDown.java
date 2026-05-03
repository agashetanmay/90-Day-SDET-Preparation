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

public class MarriottAutoSuggestedDropDown {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		  options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));

		driver.get("https://www.marriott.com/default.mi");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement destinationBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='input-text-Destination']")));

		js.executeScript("arguments[0].scrollIntoView();", destinationBox);
		Thread.sleep(1000);
		destinationBox.click(); // destination dropdown will open in 2nd click
		Thread.sleep(1000);
		destinationBox.sendKeys("nagpur khapri");

		List<WebElement> searchDropdown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//span[contains(@class,'text-container')]/span[@data-testid='ui-library-Text' and contains(@class,'text-primary')]")));

		for (WebElement destination : searchDropdown) {
			String places = destination.getText().toLowerCase();
			
			System.out.println(places);
			if ( places.equalsIgnoreCase("khapri raja"))
			{
				destination.click();
				System.out.println("from 1st click");
			}
			else if(places.contains("khapri raja")){
				
				destination.click();
				System.out.println("from 2nd click");
				break;
			}
			
		}
		
	}
}