import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    private WebDriver webDriver;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement signInButton;

    LinkedinLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private void initElements() {
        loginField = webDriver.findElement ( By.id ( "login-email"));
        passwordField = webDriver.findElement ( By.id ( "login-password" ));
        signInButton = webDriver.findElement ( By.id ("login-submit"));
            }
    public void login(String email, String password) {
        initElements ();
        loginField.sendKeys (email);
        passwordField.sendKeys (password);
        signInButton.click();
    }

//    public boolean isSignInButtonDisplayed() {
//        return signInButton.isDisplayed ();
//    }

    public String getCurrentPageTitle() {
        return webDriver.getTitle ();
    }

 }




