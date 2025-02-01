package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public WebDriver driver;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    private By emailField = By.xpath("//*[@data-qa='login-email']");
    private By passwordField = By.xpath("//*[@data-qa='login-password']");
    private By loginButton = By.xpath("//*[@data-qa='login-button']");

    public void insertEmail(String text) {
        sendKeys(emailField, text, 20);
    }

    public void insertPassword(String text) {
        sendKeys(passwordField, text, 20);
    }

    public void clickOnLoginButton() {
        click(loginButton, 20);

    }

    public HomePage loginFeature(String email, String password) {
        insertEmail(email);
        insertPassword(password);
        clickOnLoginButton();
        return new HomePage(driver);

    }


}
