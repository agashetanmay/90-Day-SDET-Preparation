package POM_Implementation;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public WebDriver driver;
	
	public  BasePage() {
		
		this.driver = DriverManager.getDriver();
	}
	

}
