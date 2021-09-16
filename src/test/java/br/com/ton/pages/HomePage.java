package br.com.ton.pages;

import br.com.ton.pages.core.TonPageObject;
import lombok.extern.java.Log;

@Log
public class HomePage extends TonPageObject {
    private final String locatorLogInButton = "//android.widget.TextView[@text='Entrar']";
    private final String locatorCreateAccountButton = "//android.widget.TextView[@text='Criar conta']";

    public HomePage reloadApp() {
        element(locatorLogInButton).waitUntilVisible();
        return this;
    }

    public HomePage accessLogInPage() {
        element(locatorLogInButton).click();
        return this;
    }

    public HomePage accessCreateAccountPage() {
        element(locatorCreateAccountButton).click();
        return this;
    }
}
