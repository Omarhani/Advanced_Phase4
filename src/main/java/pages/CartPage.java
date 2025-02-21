package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CartPage extends MethodHandles {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    //locators
    private final By emailSubscription = By.id("susbscribe_email");
    private final By submitButton = By.xpath("//button[@id='subscribe']");
    private final By successfullmessage = By.xpath("//div[text()='You have been successfully subscribed!']");
    //Actions
    public void verifySubcriptionInCart(String email){

        sendKeys(emailSubscription,email,10);
        click(submitButton,10);
    }
    public boolean successfulMessageIsDisplayed(){

       return isDisplayed(successfullmessage,10);
    }

}
