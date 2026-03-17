package SeleniumQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeShadowDomOnTechWithJatin {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://jatin99.github.io/ShadowDomAssignment/");

		By inputTextBoxSelector = By.cssSelector("input[id='email']");
		WebElement inputTextBox = driver.findElement(inputTextBoxSelector);
		inputTextBox.sendKeys("tagas390@marriott.com");

		By divHeaderLocator = By.cssSelector("div.header");
		WebElement headerText = driver.findElement(divHeaderLocator);
		System.out.println(headerText.getText());

		By userNameSelector = By.cssSelector("input[name='username']");
		WebElement userNameTextBox = driver.findElement(userNameSelector);
		userNameTextBox.clear();
		userNameTextBox.sendKeys("hello tanmay");

		System.out.println(driver.findElement(By.cssSelector("button[type='submit']")).getText());

		By item = By.xpath("//div[@class='card']/ul/li");
		WebElement item1 = driver.findElement(item);
		System.out.println(item1.getText());

		// By itemList = By.xpath("//div[@class='card']/ul/li");
		By itemList = By.cssSelector("ul>li");
		List<WebElement> lists = driver.findElements(itemList);
		for (WebElement l : lists) {

			System.out.println(l.getText());
		}

		// finding the div in the shodow locator

		By shadowDomWebLocator = By.xpath("//my-component");
		WebElement shadowDomLocator = driver.findElement(shadowDomWebLocator);
		SearchContext shadowContext = shadowDomLocator.getShadowRoot();
		WebElement shadowDivHeader = shadowContext.findElement(By.cssSelector("div.header"));
		System.out.println(shadowDivHeader.getText());
		
		

	}

}
