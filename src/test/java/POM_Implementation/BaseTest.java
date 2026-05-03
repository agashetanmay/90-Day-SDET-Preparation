package POM_Implementation;


public class BaseTest {
	public void setUp() {
		DriverManager.setDriver("chrome");
        DriverManager.getDriver().get("https://www.makemytrip.com");
        DriverManager.getDriver().manage().window().maximize();

	}
	
	
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
