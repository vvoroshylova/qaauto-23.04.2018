import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
        linkedinLoginPage.login ( "vikaposts1@gmail.com", "Iamnewhere" );
        LinkedinHomePage linkedinHomePage = new LinkedinHomePage ( webDriver );
        Assert.assertEquals ( linkedinHomePage.getCurrentUrl (),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong" );
        Assert.assertTrue ( linkedinHomePage.getCurrentTitle ().contains ( "LinkedIn" ),
                "Home page Title is wrong." );
    }

    @Test
    public void negativeLoginTestWrongPassword() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );

        linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
        linkedinLoginPage.login ( "vikaposts1@gmail.com", "1" );
        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage ( webDriver );
        Assert.assertEquals ( linkedinErrorPage.getCurrentUrl (),
                "Login-Submit page url is wrong" );
        Assert.assertEquals ( linkedinErrorPage.getCurrentTitle (),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong" );
        Assert.assertEquals ( linkedinErrorPage.errorMessage.getText (),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed" );

    }

    @Test
    public void negativeLoginTestEmptyFields() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        linkedinLoginPage.login ( "", "" );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
    }

    @Test
    public void negativeLoginTestWrongemail() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );

        linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertTrue ( linkedinLoginPage.isSignInButtonDisplayed (),
                "Sign In button is not displayed" );
        linkedinLoginPage.login ( "@@@", "Iamnewhere" );
        LinkedinErrorPage linkedinErrorPage = new LinkedinErrorPage ( webDriver );
        Assert.assertEquals ( linkedinErrorPage.getCurrentUrl (),
                "Login-Submit page url is wrong" );
        Assert.assertEquals ( linkedinErrorPage.getCurrentTitle (),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong" );
        Assert.assertEquals ( linkedinErrorPage.errorMessage.getText (),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed" );

    }
}

