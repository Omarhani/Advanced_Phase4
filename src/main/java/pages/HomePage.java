package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {

        super(driver);
    }

     private final By signup_Link = By.xpath("//a[text()=' Signup / Login']");
    private final By logIn = By.xpath("//header[@id='header']//ul/li/a[text()=' Logged in as ']");

    public LoginPage clickOnSignupLink(){


        click(signup_Link,5);

        return new LoginPage(driver);
    }

    public boolean logInisDisplayed(){

        return isDisplayed(logIn,5);
    }






}
