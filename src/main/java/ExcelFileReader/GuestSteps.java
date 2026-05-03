package ExcelFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinitions extends TestBase {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        String url = testData.get("URL");
        System.out.println("Navigating to: " + url);
        // driver.get(url);
    }

    @When("user enters credentials")
    public void user_enters_credentials() {
        String username = testData.get("Username");
        String password = testData.get("Password");
        System.out.println("Using credentials: " + username + " / " + password);
        // driver.findElement(...).sendKeys(username);
        // driver.findElement(...).sendKeys(password);
    }

    @Then("login should be successful")
    public void login_should_be_successful() {
        String expectedMessage = testData.get("ExpectedMessage");
        System.out.println("Verifying message: " + expectedMessage);
        // Assert.assertEquals(actualMessage, expectedMessage);
    }
}
