import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
            WebDriver webDriver = new FirefoxDriver();
            webDriver.get("http://linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();


        Assert.assertEquals((actualLoginPageTitle),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        WebElement loginField = webDriver.findElement(By.id("login-email"));
        loginField.sendKeys("vikaposts1@gmail.com");
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        passwordField.sendKeys("Wrongpassword");
        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();
        sleep ( 3000);

        Assert.assertFalse(webDriver.getPageSource().contains("Home"), "Valid credentials");


        loginField = webDriver.findElement (By.id("login-email"));
       loginField.sendKeys("vikaposts1@gmail.com");
       passwordField = webDriver.findElement(By.id("login-password"));
       passwordField.sendKeys("Iamnewhere");
       signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
       signInButton.click();

     sleep ( 3000);

        String actualTitle = webDriver.getTitle();
        String expectedTitle = "LinkedInX";
        assertEquals(expectedTitle,actualTitle,"failed because....");

        Assert.assertTrue(signInButton.isDisplayed(),
                "Sign In button is not Displayed");

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong");

        String actualHomePageTitle = webDriver.getTitle();

Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
"Home page url is wrong.");

Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
        "Page title did not change after Sign In");



        webDriver.close();


            }

    }