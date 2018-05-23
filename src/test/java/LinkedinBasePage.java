import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinBasePage {
    protected WebDriver webDriver;
    protected WebElement errorMessage;
    protected WebElement emailField;

    public LinkedinBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl ();
    }
    public String getCurrentTitle() {
        return webDriver.getTitle ();
    }
    public boolean isPageLoaded() {
    return emailField.isDisplayed();
       }
    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}


