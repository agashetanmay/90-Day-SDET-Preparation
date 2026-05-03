package FileDownloadUsingSelenium;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fileDownload {

	public static void main(String[] args) throws InterruptedException {
		
		
     String downloadPath = System.getProperty("user.dir")+File.separator+"jenkinDownload";
     
     File jenkinDownload = new File(downloadPath);
     
     if(!jenkinDownload.exists()) { //if folder does not exist then it will create the folder
    	 System.out.println("jenkins folder not present");
    	 if( jenkinDownload.mkdir()) {
    		 System.out.println("created jenkins download directory!!");
    	 } 
     }
   
      Map<String,Object> prefs = new HashMap();
      prefs.put("download.default_directory", downloadPath);
      prefs.put("download.promt_for_download", false); //since we are direclty download the file we make this as false
   
     ChromeOptions option = new ChromeOptions();
     option.setExperimentalOption("prefs", prefs);
     
     WebDriver driver = new ChromeDriver(option);
     driver.get("https://get.jenkins.io/war-stable/2.541.3/jenkins.war");
     
     // check file has been downloaded in the folder
     
     int timeoutSecond =60;
     int elapsedTime=0;
     
     File  file = new File(downloadPath, "jenkins.war");
    
    
     while(!file.exists() && elapsedTime < timeoutSecond) {
    	 Thread.sleep(1000);
    	 elapsedTime++;
    	 System.out.println("waiting... for file to download");
     }
     if(file.exists()) {
    	 System.out.println("file download successfully");
     }
     else {
    	 System.out.println("file could not able to download...");
     } 
	}

}
