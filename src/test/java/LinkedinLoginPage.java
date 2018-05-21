import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage {

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;

    LinkedinLoginPage(WebDriver webDriver) {
        super (webDriver);
            }

    private void initElements() {
        emailField = webDriver.findElement ( By.id ( "login-email" ) );
        passwordField = webDriver.findElement ( By.id ( "login-password" ) );
        signInButton = webDriver.findElement ( By.id ( "login-submit" ) );
    }
    public void login(String email, String password) {
        emailField.sendKeys ( email );
        passwordField.sendKeys ( password );
        signInButton.click ();
    }
    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed ();
    }
public String getCurrentUrl() {
        return webDriver.getCurrentUrl ();
        }
public String getCurrentTitle() {
        return webDriver.getTitle();

}
}





