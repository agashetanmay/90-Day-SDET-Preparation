package DevTool;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.Headers;

public class authentication {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        String auth = "authorized:password001";
        
        String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());

        Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("Authorization", encodedAuth); 

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headersMap)));

        driver.get("https://testpages.eviltester.com/styled/auth/basic-auth-results.html");
        System.out.println(driver.getCurrentUrl());
    }

    }
