package SeleniumQuestions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandelProgram {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

		By newWindowMessageLocator = By.xpath(
				"//div[contains(@class, 'col-md-8 col-lg-8 col-xl-8')]/button[contains(text(),'New Window Message')]");

		WebElement newWindowMessageButton = driver.findElement(newWindowMessageLocator);

		String parentWindow = driver.getWindowHandle();
		newWindowMessageButton.click();

		Set<String> windows = driver.getWindowHandles();

		if (windows.size() >= 2) {
			
			for (String window : windows) {

				if (!(window.contains(parentWindow))) {
					driver.switchTo().window(window);

					if (driver.getTitle().contains("Selenium Practice")) {
						driver.close();   // this will close the child window
						Thread.sleep(3000);
						driver.switchTo().window(parentWindow);
						driver.close();    // this will close the parent window 
						
					}
				}
				

			}
			

		}

	}

}
