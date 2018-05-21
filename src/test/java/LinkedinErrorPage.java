import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinErrorPage {
    private WebDriver webDriver;
    private WebElement errorMessage;

    public LinkedinErrorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    private void initElements() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }

    public String getErrorMessageText() {
        return errorMessage.getText ();


        }

    }






