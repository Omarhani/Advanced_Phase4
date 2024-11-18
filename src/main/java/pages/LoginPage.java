package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.name("email");

    private final By passwordFiled = By.name("password");

    private final By loginButton  = By.cssSelector("[data-qa='login-button']");

    private void insertEmail(String username){
        sendKeys(emailField,username, 3);
    }

    private void insertPassword(String password){
        sendKeys(passwordFiled,password, 4);
    }

    private void clickOnLoginButton(){
        click(loginButton, 6);
    }

    public LoginPage loginFeature(String email, String password){
        insertEmail(email);
        insertPassword(password);
        clickOnLoginButton();
        return new LoginPage(driver);
    }
}
