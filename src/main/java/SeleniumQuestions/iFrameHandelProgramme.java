package SeleniumQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iFrameHandelProgramme {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
        
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
       
		List<WebElement> frames = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='col-md-8 col-lg-8 col-xl-8']/iframe")));
		
		int frameSize=frames.size();
		

		
		for(int i=0;i<frameSize;i++) {
			if(i==1) {
			driver.switchTo().frame(1);
			System.out.println("switched successfully to iframe");
			}
			driver.switchTo().defaultContent();
			
			
		}
	}

}
