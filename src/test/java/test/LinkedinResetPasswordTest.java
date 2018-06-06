package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinRequestPasswordResetPage;
import page.LinkedinRequestPasswordResetSubmitPage;
import page.LinkedinSetNewPasswordPage;
import page.LinkedinSuccessfulPasswordResetPage;

public class LinkedinResetPasswordTest extends LinkedinBaseTest {

    @Test
    public void successfulPasswordResetTest() {
        String userEmail = "vikaposts1@gmail.com";
        String newUserPassword = "P@ssword12345";

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Sign in button is not displayed");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage =
                linkedinLoginPage.clickOnForgotPasswordLink ();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded (),
                "RequestPasswordResetPage is not loaded" );

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage =
                linkedinRequestPasswordResetPage.submitUserEmail ( userEmail );
                Assert.assertTrue ( linkedinRequestPasswordResetSubmitPage.isPageLoaded (),
                "RequestPasswordResetSubmitPage is not loaded" );

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage =
                linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail ();
        Assert.assertTrue ( linkedinSetNewPasswordPage.isPageLoaded (),
                "SetNewPasswordPage is not loaded" );

        LinkedinSuccessfulPasswordResetPage linkedinSuccessfulPasswordResetPage =
                linkedinSetNewPasswordPage.setNewUserPassword (newUserPassword);
        Assert.assertTrue ( linkedinSuccessfulPasswordResetPage.isPageLoaded (),
                "NewPasswordPage page is not loaded." );

           }
}

