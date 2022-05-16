package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPageSteps {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	AccountPage accountpage;

	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable dataTable) {
		List<Map<String, String>> credlist = dataTable.asMaps();
		String username = credlist.get(0).get("username");
		String password = credlist.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountpage = loginpage.doLogin(username, password);
	}

	@Given("user is on Accounts Page")
	public void user_is_on_accounts_page() {
		accountpage.getAccountsPagetitle();
	}

	@When("user gets Accounts section")
	public void user_gets_accounts_section(DataTable sectiontable) {
		List<String> expectedsectionlist = sectiontable.asList();
		System.out.println("Expected section list :" + expectedsectionlist);
		List<String> actualsectionlist = accountpage.getaccountssectionlist();
		System.out.println("Actual section list :" + actualsectionlist);
		Assert.assertTrue(expectedsectionlist.containsAll(actualsectionlist));
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedsectioncount) {
		int actualsectioncount = accountpage.getaccountsectioncount();
		Assert.assertTrue(expectedsectioncount == actualsectioncount);

	}

}
