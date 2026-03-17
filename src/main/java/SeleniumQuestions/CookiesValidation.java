package SeleniumQuestions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesValidation {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20L));

		wd.manage().deleteAllCookies();
		wd.get("https://www.marriott.com/default.mi");

		Cookie cookie_1 = new Cookie("TestCookie1", "CookieValue1");
		Cookie cookie_2 = new Cookie("TestCookie2", "CookieValue2");
         
		wd.manage().addCookie(cookie_1);
		wd.manage().addCookie(cookie_2);
		Set<Cookie> cookies = wd.manage().getCookies();
		System.out.println(cookies);
		System.out.println(cookies.size());

		for (Cookie c : cookies) {
			System.out.println(c.getName() + ":::" + c.getValue());
		}

	}
}
