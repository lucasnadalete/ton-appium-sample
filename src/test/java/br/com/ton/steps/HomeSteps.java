package br.com.ton.steps;

import br.com.ton.pages.HomePage;
import br.com.ton.pages.LoginPage;
import br.com.ton.pages.ModalHomePage;
import lombok.Getter;
import net.thucydides.core.annotations.Step;

@Getter
public class HomeSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private ModalHomePage modalHomePage;

    @Step
    public void accessHome() {
        getHomePage().reloadApp();
    }

    @Step
    public void accessLogInOption() {
        getHomePage().accessLogInPage();
        getLoginPage().getForgetPasswordTextAction();
    }

    @Step
    public void accessCreateAccountOption() {
        getHomePage().accessCreateAccountPage();
        getModalHomePage().getClientQuestionMessage();
    }
}
