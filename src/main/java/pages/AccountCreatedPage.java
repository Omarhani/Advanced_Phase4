package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class AccountCreatedPage extends MethodHandles {



    public AccountCreatedPage(WebDriver driver){

        super(driver);
    }


    // Locators

    private final By accountCreated = By.xpath("//h2[@data-qa='account-created']");

    private final By continue_Btn = By.xpath("//a[@data-qa='continue-button']");









    public boolean accountCreatedIsDisplayed(){

        return isDisplayed(accountCreated,35);

    }


    public HomePage clickOnContinueButton(){

        clickWithActions(continue_Btn,35);

        return new HomePage(driver);

    }




}
