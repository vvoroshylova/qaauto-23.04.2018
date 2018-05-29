import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinResetPasswordSubmitPage extends LinkedinBasePage

{
    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement instructionMessage;
    @FindBy(id = "reseturl")
    private WebElement resetLinkButton;
    @FindBy(xpath = "//a[@class='different__email different__email--desktop']")
    private WebElement tryDifferentEmailButton;


    @Override
    public boolean isPageLoaded() {
        return instructionMessage.isDisplayed ();
    }

    public boolean isTryDifferentEmailButtonDisplayed() {
        return tryDifferentEmailButton.isDisplayed ();
    }

    public boolean isResendLinkButtonDisplayed() {
        return resetLinkButton.isDisplayed ();
    }

    public void clickOnTryDifferentEmailButton() {
        tryDifferentEmailButton.click ();
    }

    public String getInstructionsMessage() {
        return instructionMessage.getText ();
    }

    public LinkedinResetPasswordSubmitPage(WebDriver webDriver) {
        super ( webDriver );
    }
}