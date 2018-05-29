import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    @FindBy(xpath = "//div[@class='alert error']//strong")
    private WebElement errorMessage;
    @FindBy(id = "session_key-login")
    private WebElement emailField;
    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    public LinkedinForgotPasswordPage clickForgotPasswordLink(){
        forgotPasswordLink.click();
        return PageFactory.initElements(webDriver, LinkedinForgotPasswordPage.class);
    }

    public boolean isForgotPasswordLinkDisplayed(){
        return forgotPasswordLink.isDisplayed();
    }
    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super ( webDriver );
        PageFactory.initElements ( webDriver, this );
    }
            public String getErrorMessageText() {
            return errorMessage.getText();


        }

    }












