package DevTool;


import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.Headers;




public class basic_Auth {
	
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	

	public static void main(String[] args) {
	     ChromeOptions options = new ChromeOptions();
	        ChromeDriver driver = new ChromeDriver(options);

	        DevTools devTools = driver.getDevTools();
	        devTools.createSession();
	        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));
	        
	        //send auth header
	        
	        Map<String,Object> headers = new HashMap<>();
	        
	        String auth = "admin:admin";
	        
//        String basicAuth = "Basic" +  new String(new Base64.Encoder(String.format("%s:%s",USERNAME,PASSWORD).getBytes()));
	        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
	        
	      headers.put("Autorization", encodedAuth);
	      
	      devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

	        driver.get("https://the-internet.herokuapp.com/basic_auth");
	    }

	}

