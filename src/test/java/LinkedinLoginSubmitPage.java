import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

        public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements() {
        emailField = webDriver.findElement(By.id("session_key-login"));
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }

       }




