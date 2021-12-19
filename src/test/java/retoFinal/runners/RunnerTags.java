package retoFinal.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (
        features = "src/test/resources/features",
        tags = "@HU",
        glue = "retoFinal.stepdefinitions",
        snippets = SnippetType.CAMELCASE )

public class RunnerTags {

}
