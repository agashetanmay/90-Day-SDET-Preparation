package SeleniumQuestions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJetAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.spicejet.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		By FromLocator = By.xpath("//div[text()='From']/parent::div//div/input");
		By ToLocator = By.xpath("//div[text()='To']/parent::div//div/input");
		
		WebElement origin = wait.until(ExpectedConditions.visibilityOfElementLocated(FromLocator));
		WebElement destination =  wait.until(ExpectedConditions.visibilityOfElementLocated(ToLocator));
		
		origin.sendKeys("nagpur");
		destination.clear();
		destination.sendKeys("BLR");
		
		By calenderPickerLocator = By.xpath("//div[@data-testid='undefined-calendar-picker']");
		WebElement calenderPicker =  wait.until(ExpectedConditions.visibilityOfElementLocated( calenderPickerLocator));
		
		By nextButtonLocator = By.xpath(".//*[local-name()='svg' and  @data-testid='svg-img']");
		WebElement nextButton = calenderPicker.findElement(nextButtonLocator);
		nextButton.click();
		
		Thread.sleep(2000);
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusMonths(2);
		String month = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = localDate.getYear();
		
		 
		By monthCalenderLocater = By.xpath("//div[@data-testid='undefined-month-"+month+"-"+year+"']");
		WebElement monthCalender = wait.until(ExpectedConditions.visibilityOfElementLocated(monthCalenderLocater));
		
		By dateLocator = By.xpath(".//div[text()='3']");
		WebElement calenderDate = monthCalender.findElement(dateLocator);
		calenderDate.click();
		
	}

}
