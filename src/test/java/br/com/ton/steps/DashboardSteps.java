package br.com.ton.steps;

import br.com.ton.pages.DashboardPage;
import lombok.Getter;
import net.thucydides.core.annotations.Step;

@Getter
public class DashboardSteps {
    private DashboardPage dashboardPage;

    @Step
    public boolean verifyActionIsDisplayed(String actionName) {
        return dashboardPage.hasExtractAccessAction(actionName);
    }
}
