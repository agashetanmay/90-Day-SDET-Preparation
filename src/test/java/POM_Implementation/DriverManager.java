package POM_Implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
	
	public static void setDriver(String browserName) {
		
		if(browserName=="chrome") {
			driver.set(new ChromeDriver());	
		}
	
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
	

	
	
	

}
