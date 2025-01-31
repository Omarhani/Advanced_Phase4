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

    private final By signup_Btn = By.xpath("//button[@data-qa='signup-button']");


    //Actions

    public void insertName(String name){

        clear(nameField,5);

        sendKeys(nameField,name,5);
    }

    public void insertEmail(String email){
        clear(emailField,10);
        sendKeys(emailField,email,10);
    }

    public SignupPage clickOnSignupBtn(){

        click(signup_Btn,5);

        return new SignupPage(driver);
    }
}
