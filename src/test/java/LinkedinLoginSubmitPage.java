import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {


    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;
    @FindBy(id = "session_key-login")
    private WebElement emailField;

    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super ( webDriver );
        PageFactory.initElements ( webDriver, this );

    }
}











