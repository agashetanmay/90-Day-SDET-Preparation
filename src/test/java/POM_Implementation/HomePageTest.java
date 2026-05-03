package POM_Implementation;



public class HomePageTest extends BaseTest {
	
	HomePage homePage = new HomePage();
	
//	@Test(description = "verifies user search the flight")
	public void FlightSearchTest() {
		
		homePage.searchFlight("chennai", "mumbai");
		
	
	
	}
	
}
