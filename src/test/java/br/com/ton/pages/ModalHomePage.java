package br.com.ton.pages;

import br.com.ton.pages.core.TonPageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ModalHomePage extends TonPageObject {
    private final String byAlreadyCustomerButton = "//android.widget.TextView[@text='Já sou cliente']";
    private final String byNotCustomerButton = "//android.widget.TextView[@text='Não sou cliente']";
    private final String msgClientQuestion = "//android.widget.TextView[@text='Você já é cliente Stone Mais?']";

    public ModalHomePage accessAlreadyCustomer() {
        WebElementFacade meAlreadyCustomerButton = element(byAlreadyCustomerButton);
        meAlreadyCustomerButton.click();
        return this;
    }

    public boolean hasAccessNotCustomer() {
        WebElementFacade meNotCustomerButton = element(byNotCustomerButton);
        return meNotCustomerButton != null;
    }

    public String getClientQuestionMessage() {
        return getMobileElementValueOrDefaultValue(element(msgClientQuestion), NOT_FOUND);
    }
}
