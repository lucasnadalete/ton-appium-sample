package br.com.ton.pages.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Getter
public abstract class TonPageObject extends PageObject {
    protected static final String NOT_FOUND = "element not found";
    EnvironmentVariables environmentVariables;

    protected AndroidDriver<MobileElement> getAndroidDriver() {
        return (AndroidDriver<MobileElement>) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    protected List<MobileElement> findByClass(String mobileClass) {
        return getAndroidDriver().findElementsByClassName(mobileClass);
    }

    protected String getMobileElementValueOrDefaultValue(WebElementFacade me, String defaultValue) {
        try {
            WebDriverWait wait = new WebDriverWait(getAndroidDriver(), 10);
            wait.until(
                    webDriver -> ExpectedConditions.visibilityOf(me).apply(webDriver)
            );
            return me.isDisplayed() ? me.getText() : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
