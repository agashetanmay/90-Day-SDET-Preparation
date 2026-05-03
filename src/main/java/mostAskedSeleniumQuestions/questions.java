package mostAskedSeleniumQuestions;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class questions {

	public static void main(String[] args) {
		
//		selenium most asked question

//		1.write the code for initialize the webdriver

		WebDriver driver = new ChromeDriver();

//		2.waits implicitlyWait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		3. explicitly Wait
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
		
//      4.fluent wait
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(2))
		        .pollingEvery(Duration.ofSeconds(3))
		        .ignoring(NoSuchElementException.class);
		
		fluentwait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));
		
  //   how to send keys to textbox     
		driver.findElement(By.xpath("//div[@class='username'")).sendKeys("username");
  //     how to perform clcik operation suing actions class
		
		
		By buttonLocator = By.xpath("text");
		Actions action = new Actions(driver);
		WbElement clickelement = driver.findElement(buttonLocator);
		action.moveToElement(element).click().build().perform();
		
		
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
		.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();


		// write the code to takes screenshot
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File src = screenshot.getScreenshotAs(OutputType.FILE);
	    String path = "./screenshot+.png";
	    File desc = new File(path); 
	    FileUtils.copyFile(src, desc);
		
		// how to scroll the the element 
	    
	    JavascriptExecutor js =  (JavascriptExecutor)driver;
	    WebElement scrollelement = driver.findElement(By.xpath("//div[@dev='fgh']"));
	    js.executeScript("argument[0].ScrollIntoView({{behavior: 'smooth', block: 'center'}})", scrollelement);
	    
	    // how to switch to child window
	    WebElement button = driver.findElement(By.xpath("[@class='test']")).click();
	    //on clicking on button it will open in new tab
	    Set<String> windows = driver.getWindowHandles();
	    
	      String parentwindow = driver.getWindowHandle();
	      
	      for(String window:windows) {
	    	 if(!(window.equalsIgnoreCase(parentwindow))) {
	    		 
	    		if(driver.switchTo().window(window).getTitle().equalsIgnoreCase("firsttitle")) {
	    			
	    			// code for your execution
	    		} 
	    	 }
	      }
	      driver.switchTo().window(parentwindow);
			System.out.println(driver.getTitle());
			
			
			// how to handel iframe
			
			List<WebElement>frames = driver.findElements(By.xpath(""));
			
			int totalframe=frames.size();
	
			for(int i =0;i<totalframe;i++) {
				
				if(i==2) {
					driver.switchTo().frame(i);
				}
				driver.switchTo().defaultContent();
			}
	    
	    
	    
	    
	    
		
		
				
				
				
	}

}
