package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    public LoginPage(WebDriver driver){

        super(driver);
    }

    //Locators

    private final By nameField = By.xpath("//input[@data-qa='signup-name']");

    private final By emailField = By.xpath("//input[@data-qa='signup-email']");

    private final By signupBtn = By.xpath("//button[@data-qa='signup-button']");


    //Actions

    public void insertName(String name){

        sendKeys(nameField,name,20);
    }

    public void insertEmail(String email){
        sendKeys(emailField,email,20);
    }

    public SignupPage clickOnSignupBtn(String name,String email){
        insertName(name);
        insertEmail(email);
        click(signupBtn,20);
        return new SignupPage(driver);
    }
}
