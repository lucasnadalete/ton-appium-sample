package br.com.ton.pages;

import br.com.ton.pages.core.TonPageObject;

public class DashboardPage extends TonPageObject {

    public boolean hasExtractAccessAction(String action) {
        String btnAction = "//android.widget.TextView[contains(@text,'" + action.trim() + "')]";
        boolean status = false;
        if (!getMobileElementValueOrDefaultValue(element(btnAction), NOT_FOUND).equalsIgnoreCase(NOT_FOUND)) {
            boolean isDisplayed = element(btnAction).isDisplayed();
            boolean isEnabled = element(btnAction).isEnabled();
            status = isDisplayed && isEnabled;
        }
        return status;
    }
}
