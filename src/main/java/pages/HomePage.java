package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By signInAndLoginLink = By.cssSelector(".fa.fa-lock");

    public LoginPage clickOnSignInAndLoginLink(){
        click(signInAndLoginLink, 5);
        return new LoginPage(driver);
    }
}
