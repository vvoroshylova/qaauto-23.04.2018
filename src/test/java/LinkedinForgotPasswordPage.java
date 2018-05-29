import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinForgotPasswordPage extends LinkedinBasePage {

    @FindBy(id = "username")
    public WebElement userNameField;
    @FindBy(id = "reset-password-submit-button")
    public WebElement submitButton;
    @FindBy(xpath = "//h2[@class='form__subtitle']")
    public WebElement instructionMessage;

    public LinkedinForgotPasswordPage(WebDriver webDriver) {
            super ( webDriver );
            PageFactory.initElements (webDriver, this);
        }
    @Override
    public boolean isPageLoaded() {
        return instructionMessage.isDisplayed();
    }
    public String getInstructionMessage(){
        return instructionMessage.getText();
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed ();}

    public LinkedinResetPasswordSubmitPage submitUserEmail(String userEmail){
        userNameField.sendKeys(userEmail);
        submitButton.click();
        return PageFactory.initElements(webDriver, LinkedinResetPasswordSubmitPage.class);
    }
    }





