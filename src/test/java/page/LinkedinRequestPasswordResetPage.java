package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {

    public static String message;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super ( webDriver );
        PageFactory.initElements ( webDriver, this );}

     public boolean isPageLoaded() {
        return userEmailField.isDisplayed ();
    }

        public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String userEmail){
            GMailService gMailService= new GMailService ();
            gMailService.connect ();
            userEmailField.sendKeys ( userEmail);
            submitButton.click ();
            message = gMailService.waitMessage("here's the link to reset your password", "vikaposts1@gmail.com", "LinkedIn <security-noreply@linkedin.com>", 60);
            return PageFactory.initElements ( webDriver, LinkedinRequestPasswordResetSubmitPage.class );


        }
    }



