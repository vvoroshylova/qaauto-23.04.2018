import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver ();
        webDriver.get ( "http://linkedin.com/" );
    }

    @AfterMethod
    public void after() {
        webDriver.close ();
    }


    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "vikaposts1@gmail.com", "Iamnewhere" },
               // { "VIKAPOSTS1@GMAIL.COM", "Iamnewhere" },
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

        linkedinLoginPage.login (email, password);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage ( webDriver );
        Assert.assertEquals ( linkedinHomePage.getCurrentUrl (),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong" );
        Assert.assertTrue ( linkedinHomePage.getCurrentTitle ().contains ( "LinkedIn" ),
                "Home page Title is wrong." );
    }

    @Test
    public void negativeReturnedToLoginSubmitTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
        linkedinLoginPage.login ( "vikaposts1@gmail.com", "1" );

        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage ( webDriver );
        Assert.assertTrue ( linkedinLoginSubmitPage.isPageLoaded (),
                "Login-Submit page is not loaded.");
        Assert.assertEquals (linkedinLoginSubmitPage.getErrorMessageText (),
                "There were one or more errors in your submission. Please correct the marked fields below.",
        "Error message text is incorrect.");
                    }

    @Test
    public void negativeLoginEmptyFieldsTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        linkedinLoginPage.login ( "", "" );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
    }

    @Test
    public void negativeLoginWrongEmailTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );
        linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        linkedinLoginPage.login ( "test@test", "Iamnewhere" );
        LinkedinLoginSubmitPage LinkedinLoginSubmitPage = new LinkedinLoginSubmitPage ( webDriver );
        Assert.assertEquals ( LinkedinLoginSubmitPage.getCurrentUrl (),
                "Login-Submit page url is wrong" );
        Assert.assertEquals ( LinkedinLoginSubmitPage.getCurrentTitle (),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong" );
        Assert.assertEquals ( LinkedinLoginSubmitPage.getErrorMessageText (),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed" );

    }
}

