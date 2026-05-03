package SeleniumQuestions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/");

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File Myfile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destifile = new File("screenshot.png");
		
		FileUtils.copyFile(Myfile, destifile);  // file Utils is comming from apache .io package
		

	}

}
