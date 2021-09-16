package br.com.ton.steps;

import br.com.ton.pages.LoginPage;
import br.com.ton.pages.ModalHomePage;
import lombok.Getter;
import net.thucydides.core.annotations.Step;

@Getter
public class ModalHomeSteps {
    private ModalHomePage modalHomePage;
    private LoginPage loginPage;

    @Step
    public String getMessageClientQuestion() {
        return getModalHomePage().getClientQuestionMessage();
    }

    @Step
    public boolean verifyOptionAccessRegisterForNonCustomers() {
        return getModalHomePage().hasAccessNotCustomer();
    }

    @Step
    public void performAlreadyCustomerAction() {
        getModalHomePage().accessAlreadyCustomer();
        getLoginPage().getForgetPasswordTextAction();
    }

}
