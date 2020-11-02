package stepDefinations;


import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefination {

	 @Given("^Validate the browser$")
	    public void validate_the_browser() throws Throwable {
	        System.out.println("Validate the browser a");

	    }

	 @When("^Browser is triggerd$")
	    public void browser_is_triggerd() throws Throwable {
	        System.out.println("Browser is triggerda");

	    }

	 @Then("^Check if browser is started$")
	    public void check_if_browser_is_started() throws Throwable {
	        System.out.println("Check if browser is started a");

	    }
	    
	@Given("^User is on Netbanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable {
        System.out.println("Block1 a");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        System.out.println("Block2 b");

    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("Block3 c");

    }

    @And("^Cards are displayed is \"([^\"]*)\"$")
    public void cards_are_displayed_is_something(String strArg1) throws Throwable {
        System.out.println(strArg1+"cards");

    }
    
    @When("^User login into application with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_something(String strArg1, String strArg2) throws Throwable {
    	System.out.println(strArg1+strArg2);
    }
    

    @When("^User signup with following details$")
    public void user_signup_with_following_details(DataTable data) throws Throwable {
    	List<List<String>> obj = data.asLists();
    	System.out.println(obj.get(0).get(0));
    	System.out.println(obj.get(0).get(1));
    	System.out.println(obj.get(1).get(1));
    }
    
    
    @When("^User login in to application with (.+) and (.+)$")
    public void user_login_into_application_with_and(String username, String password) throws Throwable {
       System.out.println(username);
       System.out.println(password);

    }
}
