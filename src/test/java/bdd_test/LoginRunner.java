package bdd_test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "bdd_test",
        features = "src/test/java/bdd_test/login.feature"
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
