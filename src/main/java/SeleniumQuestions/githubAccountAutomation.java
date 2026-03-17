package SeleniumQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class githubAccountAutomation {

	public static void main(String[] args) {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(20L));
		
		wd.get("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F%3Cuser-name%3E&source=header");
		
		WebElement emailTxtBox = wd.findElement(By.xpath("//input[@id='email']"));
		WebElement passwordTxtBox = wd.findElement(By.xpath("//input[@id='password']"));
		WebElement userName = wd.findElement(By.xpath("//input[@id='login']"));
		By CountryDropDown = By.xpath("//button[contains(@id,'select-panel') and @aria-labelledby='country-dropdown-label' ]");
	    By searchBoxText = By.xpath("//input[contains(@id,'select-panel') and @autofocus='autofocus' ]");
		
		
		WebElement email = wait.until(ExpectedConditions.visibilityOf(emailTxtBox));
		email.sendKeys("tanmay@yotmail.com");
		
	   WebElement password = wait.until(ExpectedConditions.visibilityOf(passwordTxtBox));
		 password.sendKeys("tanmay@#$1234");
		 
       WebElement username = wait.until(ExpectedConditions.visibilityOf(userName));
       username.sendKeys("tanmay12345098789");
       
       WebElement countryDropDown = wait.until(ExpectedConditions.elementToBeClickable(CountryDropDown));
       countryDropDown.click();
       
       WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxText));
       
       searchTextBox.sendKeys("albania");
       
       
		

	}

}
