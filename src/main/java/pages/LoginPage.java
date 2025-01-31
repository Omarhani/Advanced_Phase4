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
    private By validationMessage=By.xpath("//*[contains(text(),'Your email or password is incorrect!')]");


    // String xx= (driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]"))).getText();
    //String x=(driver.findElement(By.cssSelector("p[style='color: red;']"))).getText();

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

    public String GetValidationMessage()
    {
        return  driver.findElement(validationMessage).getText();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


}
