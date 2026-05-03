package POM_Implementation;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

	private By fromCity = By.id("fromCity");
	private By toCity = By.id("toCity");
	private By searchButton = By.xpath("//a[text()='Search']");

	public void searchFlight(String from, String to) {
		driver.findElement(fromCity).sendKeys(from);
		driver.findElement(toCity).sendKeys(to);
		driver.findElement(searchButton).click();
	}
	
}
