package SeleniumQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IBM_AssignmentShadowDom {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		String ExpectedPageTitle = "IBM 3592 Tape Cartridge";
		driver.get("https://www.ibm.com/in-en");

		By InfrastructureLocator = By.xpath("//c4d-megamenu-top-nav-menu[@menu-label='Infrastructure']");
		WebElement InfrastructureMenu = driver.findElement(InfrastructureLocator);
		SearchContext InfrastructureShadow = InfrastructureMenu.getShadowRoot();

		// shadow root dom is always work with CSS selector
		WebElement InfrastructureLink = InfrastructureShadow.findElement(By.cssSelector("a[role=button]"));
		InfrastructureLink.click();

		WebElement IBMTapeCartridge = driver.findElement(By.xpath("//c4d-megamenu-category-link[@title='IBM 3592 Tape Cartridge']"));
		IBMTapeCartridge.click();
		String IBMTapeCartridgeActual = driver.getTitle();

		if (IBMTapeCartridgeActual.contains(ExpectedPageTitle)) {
			System.out.println("you are navigated successfully to: " + IBMTapeCartridgeActual);
		}
		driver.quit();

	}

}
