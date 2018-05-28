import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver ();
        webDriver.get ( "http://linkedin.com/" );
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "vikaposts1@gmail.com", "Iamnewhere" },
//                { "VIKAPOSTS1@GMAIL.COM", "Iamnewhere" },
        };
    }

    @Test(dataProvider="validDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login (email, password);

                Assert.assertEquals ( linkedinHomePage.getCurrentUrl (),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong" );
        Assert.assertTrue ( linkedinHomePage.getCurrentTitle ().contains ( "LinkedIn" ),
                "Home page Title is wrong." );
    }

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                {"vikaposts1@gmail.com", "wrongpassword" },
//                {"wrong@email", "Iamnewhere" },
//                {"wrong@email", "wrongpassword"}
        };
    }
    @Test (dataProvider="invalidDataProvider")
    public void negativeReturnedToLoginSubmitTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
        linkedinLoginPage.login (email, password);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage ( webDriver );
        Assert.assertTrue ( linkedinLoginSubmitPage.isPageLoaded (),
                "Login-Submit page is not loaded.");
        Assert.assertEquals (linkedinLoginSubmitPage.getErrorMessageText (),
                "There were one or more errors in your submission. Please correct the marked fields below.",
        "Error message text is incorrect.");
                    }

    @DataProvider
    public Object[][] emptyDataProvider() {
        return new Object[][]{
                { "", "" },
                { "", "Iamnewhere" },
                { "vikaposts1@gmail.com", "" },
        };
    }
    @Test(dataProvider = "emptyDataProvider")
    public void loginWithEmptyUsernameAndPassword(String email, String password)  {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login(email, password);
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
    }
    @AfterMethod
    public void after() {
        webDriver.close ();
    }
}

