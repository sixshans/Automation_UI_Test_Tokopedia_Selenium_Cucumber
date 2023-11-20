package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue= {"StepDef"},
        plugin = {"html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class TestRunner {
}
