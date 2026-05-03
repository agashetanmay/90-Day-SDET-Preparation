package fluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fluentWaitCode {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
		
		Wait<WebDriver> fluentWait = new FluentWait(driver)
				.pollingEvery(Duration.ofSeconds(5))
				.withTimeout(Duration.ofSeconds(5))
				.ignoring((NoSuchElementException.class);
				
		WebElement button =	fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath(null)));
		
		button.click();
						

	}

}
