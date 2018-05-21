import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage extends LinkedinBasePage{

   private WebElement errorMessage;
   private WebElement emailField;

   public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super (webDriver);
        initElements ();
            }

    private void initElements() {
       emailField = webDriver.findElement ( By.id("session_key-login"));
       errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
            }

    public String getErrorMessageText() {
        return errorMessage.getText ();
    }
            public boolean isPageLoaded() {
            return emailField.isDisplayed ();
        }
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl ();
        }
public String getCurrentTitle() {return webDriver.getTitle();

}
}





