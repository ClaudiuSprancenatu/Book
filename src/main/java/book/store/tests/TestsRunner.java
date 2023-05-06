package book.store.tests;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"book.store"}
)
public class TestsRunner extends AbstractTestNGCucumberTests{
}
