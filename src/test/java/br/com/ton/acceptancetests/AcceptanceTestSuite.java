package br.com.ton.acceptancetests;

import io.cucumber.junit.CucumberOptions;
import lombok.Getter;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "br.com.ton",
        plugin = {"pretty:output", "html:target/cucumber"},
        tags = "@smoke or @functional"
)
@Getter
public class AcceptanceTestSuite {
}
