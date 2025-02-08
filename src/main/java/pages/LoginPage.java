package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.MethodHandles;


public class LoginPage extends MethodHandles {

    public LoginPage(WebDriver driver){

        super(driver);
    }

    //Locators

    private final By nameField = By.xpath("//input[@data-qa='signup-name']");

    private final By emailField = By.xpath("//input[@data-qa='signup-email']");

    private final By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    private final By passwordField = By.xpath("//*[@data-qa='login-password']");
    private final By loginButton = By.xpath("//*[@data-qa='login-button']");
    private final By validationMessage=By.xpath("//*[contains(text(),'Your email or password is incorrect!')]");

    //Actions

    private void insertName(String name){

        sendKeys(nameField,name,20);
    }

    private void insertEmail(String email){
        sendKeys(emailField,email,20);
    }
  
    private void insertPassword(String text) {
        sendKeys(passwordField, text, 20);
    }

    private void clickOnLoginButton() {
        click(loginButton, 20);

    }

    public SignupPage clickOnSignupBtn(String name,String email){
        insertName(name);
        insertEmail(email);
        click(signupBtn,20);
        return new SignupPage(driver);
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
  
    public String getLoginPageURL(){
        return getCurrentURL();
    }



}
