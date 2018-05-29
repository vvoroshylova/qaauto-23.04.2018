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
                { "VIKAPOSTS1@GMAIL.COM", "Iamnewhere" },
        };
    }
    @Test(dataProvider="validDataProvider")
    public void successfulLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );
        Assert.assertTrue ( linkedinLoginPage.isPageLoaded (),
                "Login Page is not loaded." );
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
        Assert.assertTrue ( linkedinLoginPage.isPageLoaded (),
                "Login page is not loaded." );
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.loginWithInvalidData(email, password);
                Assert.assertFalse ( linkedinLoginSubmitPage.isPageLoaded (),
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
        Assert.assertTrue ( linkedinLoginPage.isPageLoaded (),
                "Login page is not loaded.");
    }



    @Test (dataProvider="invalidDataProvider")
    public void successfulPasswordResetTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage ( webDriver );
        Assert.assertEquals ( linkedinLoginPage.getCurrentTitle (),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong" );
        Assert.assertTrue ( linkedinLoginPage.isPageLoaded (),
                "Login page is not loaded." );
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.loginWithInvalidData(email, password);
        Assert.assertFalse ( linkedinLoginSubmitPage.isPageLoaded (),
                "Login-Submit page is not loaded.");
        Assert.assertEquals (linkedinLoginSubmitPage.getErrorMessageText (),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text is incorrect.");
LinkedinForgotPasswordPage linkedinForgotPasswordPage = linkedinLoginSubmitPage.clickForgotPasswordLink();
        Assert.assertTrue(linkedinForgotPasswordPage.isPageLoaded(),
                "Reset Password Page is not loaded");
        Assert.assertEquals(linkedinForgotPasswordPage.getCurrentTitle(),
                "Reset Password | LinkedIn",
                "Page title is wrong");
        Assert.assertTrue(linkedinForgotPasswordPage.userNameField.isDisplayed (),
                "Email text field is missing");
        Assert.assertTrue(linkedinForgotPasswordPage.isSubmitButtonDisplayed(),
                "Submit button is missing");
        Assert.assertEquals(linkedinForgotPasswordPage.getInstructionMessage(),
                "Please enter your email or phone",
                "Wrong instructions message is displayed");}
    LinkedinResetPasswordSubmitPage linkedinResetPasswordSubmitPage = linkedinForgotPasswordPage.submitUserEmail(userEmail);
           Assert.assertTrue(linkedinResetPasswordSubmitPage.isPageLoaded(),"Reset Password Submit Page is not loaded");
        Assert.assertEquals(linkedinResetPasswordSubmitPage.getCurrentTitle(),
                "Please check your mail for reset password link. | LinkedIn",
                "Page title is wrong");

    @AfterMethod
    public void after() {
        webDriver.close ();
    }
}

