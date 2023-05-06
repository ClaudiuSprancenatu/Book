package book.store.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static book.store.steps.GlobalActions.sendRequestToRest;

public class TestSteps {
    WebDriver driver = new ChromeDriver();


    @BeforeTest
    private void before() {
        System.out.println("Before");
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/claudiusprancenatu/Downloads/chromedriver_mac64/chromedriver");
    }


    @Given("^I create a user username (.*) and password (.*)$")
    public void iCreateAUser(String userName, String password) {
        RequestSpecification requestSpecification;
        requestSpecification = RequestSpecificationBuilders.postDemoQaCreateUser(userName, password);
        Response createResponseForUserCreation = sendRequestToRest("post", requestSpecification, 201, null);
        assert createResponseForUserCreation != null;

    }

    @Then("I open browser")
    public void iOpenBrowser() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/claudiusprancenatu/Downloads/chromedriver_mac64/chromedriver");
        // Instantiate a ChromeDriver class.
//        WebDriver driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.get("https://www.geeksforgeeks.org/");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
