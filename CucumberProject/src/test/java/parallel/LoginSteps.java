package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		Assert.assertTrue(title.contains(expectedtitle));
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(loginpage.Forgotpwdlinkdisplayed());
	}

	@When("user enter valid username {string}")
	public void user_enter_valid_username(String username) {
		// Write code here that turns the phrase above into concrete actions
		loginpage.enterusername(username);
	}

	@When("user enter valid password {string}")
	public void user_enter_valid_password(String password) {
		// Write code here that turns the phrase above into concrete actions
		loginpage.enterpassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		loginpage.clickonLogin();
	}

	@Then("user gets the title of the  page")
	public void user_gets_the_title_of_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
	}

}
