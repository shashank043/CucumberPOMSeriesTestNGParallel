package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
//import org.junit.Assert;


import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;




public class AccountsPageSteps {
	
private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
private AccountsPage accountsPage;
	
	@Given("user has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable credentailsTable) {
	
	   List<Map<String,String>> credList =credentailsTable.asMaps();
	   String username=credList.get(0).get("username");
	   String password=credList.get(0).get("password");
	   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   accountsPage=loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title=accountsPage.getAccountsPageTitle();
		System.out.println("Accounts page title is: "+title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expectedAccountsSectionsList=sectionsTable.asList();
		System.out.println("My Expected Accounts section list: "+ expectedAccountsSectionsList);
		List<String> actualAccountsSectionsList=accountsPage.getAccountsSectionList();
		System.out.println("My Actual Accounts section list: "+ actualAccountsSectionsList);
		Assert.assertEquals(actualAccountsSectionsList, expectedAccountsSectionsList);
		Assert.assertTrue(expectedAccountsSectionsList.containsAll(actualAccountsSectionsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedsectioncount) {
	 Assert.assertTrue(accountsPage.getAccountsSectionCount()==expectedsectioncount);  
	}
}
