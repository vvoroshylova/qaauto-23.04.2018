package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinSetNewPasswordPage extends LinkedinBasePage{
    public static String message;

    @FindBy(id = "newPassword")
    private WebElement newPasswordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "reset-password-submit-button")
    private WebElement submitPasswordButton;

    public LinkedinSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return newPasswordInput.isDisplayed ();
    }

    public LinkedinSuccessfulPasswordResetPage setNewUserPassword(String newUserPassword){
        return new LinkedinSuccessfulPasswordResetPage(webDriver);

    }
}
