package SeleniumQuestions;

import java.util.Objects;

import org.openqa.selenium.By;

public class dataDrivenTestingForLoginTest {
	
	@Test(dataProvider="loginDataProvider")
	public void loginToTheApplication(String username, String Password) {
		
		driver.get("http://xyz.com");
		
		driver.findElement(By.xpath("").sendKeys(username));
		driver.findElement(By.xpath("").sendKeys(password));
		
	}
	@Dataprovider(name="loginDataProivider",parallel=true)
	public Object[][] dataDrivenForLoginTest() {
		return new Object{ {"username","password"},
		        {"username1","password1"},
		        {"username2","password2"}
		};
		
	}


	public static void main(String[] args) {

		
		
		
		
		

	}

}
