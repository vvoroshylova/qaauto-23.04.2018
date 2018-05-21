import org.openqa.selenium.WebDriver;

public class LinkedinHomePage extends LinkedinBasePage {

    public LinkedinHomePage(WebDriver webDriver) {
        super ( webDriver );
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl ();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle ();
    }


    }

