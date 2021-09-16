package br.com.ton.stepdefs;

import br.com.ton.steps.DashboardSteps;
import br.com.ton.steps.HomeSteps;
import br.com.ton.steps.LoginSteps;
import br.com.ton.steps.ModalHomeSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

@Getter
public class LoginStepDefinitions {
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private HomeSteps homeSteps;
    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private ModalHomeSteps modalHomeSteps;

    @Given("I want to access Ton app")
    public void givenUserAccessAccount() {
        getHomeSteps().accessHome();
    }

    @Given("I access Login option")
    public void givenUserAccessLogInOption() {
        getHomeSteps().accessLogInOption();
    }

    @Given("I fill the username {word} and password {word}")
    public void givenTypeCredentials(String email, String password) {
        getLoginSteps().fillCredentialsData(email, password);
    }

    @Given("I fill the username and password with valid credentials")
    public void givenTypeValidCredentials() {
        getLoginSteps().fillValidCredentialsData();
    }

    @When("I access Create Account option")
    public void givenUserAccessCreateAccountOption() {
        getHomeSteps().accessCreateAccountOption();
    }

    @When("I click in the Enter button")
    public void whenClickEnterButton() {
        getLoginSteps().performEnterAction();
    }

    @Then("The page highlight the email field as invalid with the message {string}")
    public void thenThePageHighlightTheEmailFieldAsInvalid(String emailFieldMessage) {
        assertEquals(emailFieldMessage.trim(), getLoginSteps().getEmailAndPasswordFieldErrorMessage().trim());
    }

    @Then("The question {string} to identify Stone Mais customer is displayed")
    public void thenTheQuestionMessageIsDisplayed(String message) {
        assertEquals(message, getModalHomeSteps().getMessageClientQuestion());
    }

    @Then("Error message must be displayed")
    public void thenModalErrorMessageDisplayed() {
        getLoginSteps().getNotificationErrorData();
        Assert.assertTrue(getLoginSteps().verifyErrorModalIsDisplayed());
    }

    @And("An error message {string} is displayed with title {string}")
    public void thenAnErrorMessageNotificationIsDisplayed(String errorMessage, String title) {
        String[] notificationData = getLoginSteps().getNotificationErrorData();
        assertEquals(title, notificationData[0].trim());
        assertEquals(errorMessage, notificationData[1].trim());
    }

    @And("The confirmation button is pressed")
    public void thenTheButtonOkInModalIsPressed() {
        getLoginSteps().confirmErroModal();
    }

    @And("I must have access to {string} action")
    public void thenHaveAccessTo(String action) {
        Assert.assertTrue(getDashboardSteps().verifyActionIsDisplayed(action));
    }

    @And("The option to access register screen is enabled")
    public void thenHasOptionToAccessRegister() {
        Assert.assertTrue(getModalHomeSteps().verifyOptionAccessRegisterForNonCustomers());
    }

    @And("The option to access login screen is performed with success")
    public void thenAccessLoginPerformedSuccess() {
        getModalHomeSteps().performAlreadyCustomerAction();
        Assert.assertTrue(getLoginSteps().verifyForgetPasswordVisible());
    }

    @And("No error message must be displayed")
    public void thenNoModalErrorMessageDisplayed() {
        Assert.assertFalse(getLoginSteps().verifyErrorModalIsDisplayed());
    }
}
