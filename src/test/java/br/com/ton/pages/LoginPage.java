package br.com.ton.pages;

import br.com.ton.pages.core.TonPageObject;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends TonPageObject {
    private final String btnAccess = "//android.view.ViewGroup[@index='7']";
    private final String byForgetPassword = "//android.widget.TextView[contains(@text, 'Esqueci minha senha')]";

    private final String msgEmailHighlight = "//android.widget.TextView[contains(@text,'Email inv')]";


    private final By titleModalMessage = By.id("android:id/alertTitle");
    private final By msgIncorrectMailPass = By.id("android:id/message");
    private final By btnOkModal = By.id("android:id/button1");

    public LoginPage typeEmail(String email) {
        MobileElement emailField = findByClass("android.widget.EditText").get(0);
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        MobileElement pwdField = findByClass("android.widget.EditText").get(1);
        pwdField.sendKeys(password);
        return this;
    }

    public LoginPage fillValidEmail() {
        String email = EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("ton.username");
        typeEmail(email);
        return this;
    }

    public LoginPage fillValidPassword() {
        String pwd = EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("ton.pwd");
        typePassword(pwd);
        return this;
    }

    public boolean isErrorModalVisible() {
        try {
            return element(titleModalMessage).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isForgetPasswordVisible() {
        try {
            return element(byForgetPassword).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    public LoginPage clickLogin() {
        element(btnAccess).click();
        return this;
    }

    public String getEmailHighlightMessageText() {
        return getMobileElementValueOrDefaultValue(element(msgEmailHighlight), NOT_FOUND);
    }

    public String[] getModalData() {
        String[] modalData = new String[2];
        modalData[0] = getMobileElementValueOrDefaultValue(element(titleModalMessage), NOT_FOUND);
        modalData[1] = getMobileElementValueOrDefaultValue(element(msgIncorrectMailPass), NOT_FOUND);
        return modalData;
    }

    public LoginPage clickOkModalButton() {
        WebElementFacade meOkModalButton = element(btnOkModal);
        meOkModalButton.click();
        return this;
    }

    public String getForgetPasswordTextAction() {
        return getMobileElementValueOrDefaultValue(element(byForgetPassword), NOT_FOUND);
    }
}
