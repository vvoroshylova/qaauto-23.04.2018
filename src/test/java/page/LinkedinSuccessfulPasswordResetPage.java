package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccessfulPasswordResetPage extends LinkedinBasePage {

    @FindBy(xpath = "//header[@class='content__header']")
    WebElement successfulMessage;
    @FindBy(id = "reset-password-submit-button")
    WebElement goToHomeButton;

    public LinkedinSuccessfulPasswordResetPage(WebDriver webDriver) {
        super ( webDriver );
        PageFactory.initElements ( webDriver, this );
    }

    public boolean isPageLoaded() {
        return successfulMessage.isDisplayed ();

    }
}
