package bdd_test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("navigate to login page")
    public void navigate_to_login_page(){
        System.out.println("navigate to login page");
    }

    @When("Enter username")
    public void enterUsername() {
        System.out.println("Enter username");
    }
    @When("Enter username {string}")
    public void enterUsername(String username) {
        System.out.println("Enter username " + username);
    }

    @And("Enter password {string}")
    public void enterPassword(String password) {
        System.out.println("Enter password " + password);
    }

    @And("click submit")
    public void clickSubmit() {
        System.out.println("click submit");
    }

    @Then("user is successfully login")
    public void userIsSuccessfullyLogin() {
        System.out.println("user is successfully login");
    }

    @When("Enter Invalid username")
    public void enterInvalidUsername() {
        System.out.println("Enter Invalid username");
    }

    @And("Enter Invalid password")
    public void enterInvalidPassword() {
        System.out.println("Enter Invalid password");
    }

    @Then("Error message will appear")
    public void errorMessageWillAppear() {
        System.out.println("Error message will appear");
    }


}
