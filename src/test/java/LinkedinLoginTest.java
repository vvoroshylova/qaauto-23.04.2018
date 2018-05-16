import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("http://linkedin.com/");

    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals((actualLoginPageTitle),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        linkedinLoginPage.login ("vikaposts1@gmail.com", "Iamnewhere");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not displayed");

            sleep ( 3000);
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong");


        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
                "Page title did not change after Sign In");
Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
"Home page url is wrong.");

        webDriver.close();


            }

@Test
public void negativeLoginTest() throws InterruptedException {
    String actualLoginPageTitle = webDriver.getTitle();

    Assert.assertEquals((actualLoginPageTitle),
            "LinkedIn: Log In or Sign Up",
            "Login page Title is wrong");

    LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        linkedinLoginPage.login("vikaposts1@gmail.com", "1");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not displayed");

        sleep ( 3000);

    String currentPageUrl = webDriver.getCurrentUrl();
    String currentPageTitle = webDriver.getTitle();

    Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit",
            "Login-Submit page url is wrong");
    Assert.assertEquals(currentPageTitle, "Sign In to LinkedIn",
            "Login-Submit page Title is wrong");

    WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

    Assert.assertEquals(errorMessage.getText(),
            "There were one or more errors in your submission. Please correct the marked fields below.",
            "Wrong error message text displayed");
}
@AfterMethod
public void after() {
        webDriver.close();
}
    }