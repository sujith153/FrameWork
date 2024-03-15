package StepDefinations;

import static org.junit.Assert.assertEquals;

import com.selenium.core.UtilityClass;
import com.selenium.page.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginSteps {
	UtilityClass util;
	LoginPage login;

	@Before
	public void loadObjects() {
		util = new UtilityClass();
		login = new LoginPage(util);
	}

	@After
	public void Browser() {

		util.getDriver().quit();
	}

	@Given("^Launch the browser and open the respective url$")
	public void launch_the_browser_and_open_the_respective_url() {
		login.launchUrl();
	}

	@Given("User enters credentials as {string} and {string}")
	public void user_enters_credentials_as_and(String user, String pass) {
		login.login(user, pass);
	}

	@And("Validate the error message")
	public void validate_the_error_message() {
		assertEquals(true, login.isErrorMsgPresent());
	}

	@And("Validate the login message as {string}")
	public void validate_the_login_message_as(String string) {
		assertEquals(string, login.getLoginMaessage());
	}

	@And("User clicks on logout button and returns to home page")
	public void user_clicks_on_logout_button_and_returns_to_home_page() {
		login.clickOnLogoutButton();
		assertEquals(true, login.isLoginFormDisplayed());
	}

}
