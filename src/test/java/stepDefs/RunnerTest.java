package stepDefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "stepDefs", // Path to your step definitions
        plugin = {"pretty", "html:target/cucumber-report.html"} // Optional: generate a report
)
public class RunnerTest {
}
