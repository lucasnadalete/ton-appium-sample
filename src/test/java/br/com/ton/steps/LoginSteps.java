package br.com.ton.steps;

import br.com.ton.pages.LoginPage;
import lombok.Getter;
import net.thucydides.core.annotations.Step;

@Getter
public class LoginSteps {
    private LoginPage loginPage;

    @Step
    public void fillCredentialsData(String email, String password) {
        if (email.equalsIgnoreCase("DEFAULT")) {
            getLoginPage().fillValidEmail();
        } else {
            getLoginPage().typeEmail(email);
        }

        if (password.equalsIgnoreCase("DEFAULT")) {
            getLoginPage().fillValidPassword();
        } else {
            getLoginPage().typePassword(password);
        }
    }

    @Step
    public void fillValidCredentialsData() {
        getLoginPage().fillValidEmail()
                .fillValidPassword();
    }

    @Step
    public void performEnterAction() {
        getLoginPage().clickLogin();
    }

    @Step
    public String getEmailAndPasswordFieldErrorMessage() {
        return getLoginPage().getEmailHighlightMessageText();
    }

    @Step
    public String[] getNotificationErrorData() {
        return getLoginPage().getModalData();
    }

    @Step
    public void confirmErroModal() {
        getLoginPage().clickOkModalButton();
    }

    @Step
    public boolean verifyForgetPasswordVisible() {
        return getLoginPage().isForgetPasswordVisible();
    }

    @Step
    public boolean verifyErrorModalIsDisplayed() {
        return getLoginPage().isErrorModalVisible();
    }
}
