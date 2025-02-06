package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class AccountCreatedPage extends MethodHandles {



    public AccountCreatedPage(WebDriver driver){

        super(driver);
    }

    private final By accountCreated = By.xpath("//h2[@data-qa='account-created']");

    private final By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public HomePage clickOnContinueButton(){

        clickWithActions(continueBtn,40);

        return new HomePage(driver);
    }
    public boolean accountCreatedIsDisplayed(){

        return isDisplayed(accountCreated,40);
    }

}
