package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

     @FindBy(xpath = "//button[@class='resend__link']")
    private WebElement resendLinkButton;

    public boolean isPageLoaded() {
        return resendLinkButton.isDisplayed();
    }

    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
           }

    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
        GMailService gMailService = new GMailService ();
        gMailService.connect ();
        String resetPasswordLink = StringUtils.substringBetween(LinkedinRequestPasswordResetPage.message,
                "click <a href="+'"',
                '"'+" style=").replace("&amp;","&");
        webDriver.get(resetPasswordLink);

        return PageFactory.initElements ( webDriver, LinkedinSetNewPasswordPage.class );
    }
}

