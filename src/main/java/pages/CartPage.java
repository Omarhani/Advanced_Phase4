package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

import java.util.List;

public class CartPage extends MethodHandles {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    //locators
    private final By emailSubscription = By.id("susbscribe_email");
    private final By submitButton = By.xpath("//button[@id='subscribe']");
    private final By successfullmessage = By.xpath("//div[text()='You have been successfully subscribed!']");

    private final By descriptions = By.xpath("//tbody//tr//*[@class='cart_description']//h4//a") ;
    private By getPriceText(int index){
        return By.xpath("//tbody//tr["+index+"]//*[@class='cart_price']//p") ;
    }
    private By getQuantitiesText(int index){
        return By.xpath("//tbody//tr["+index+"]//*[@class='cart_quantity']//button") ;
    }
    private By getTotalsText(int index){
        return By.xpath("//tbody//tr["+index+"]//*[@class='cart_total']//p") ;
    }
    //Actions
    public void verifySubcriptionInCart(String email){

        sendKeys(emailSubscription,email,10);
        click(submitButton,10);
    }
    public boolean successfulMessageIsDisplayed(){

       return isDisplayed(successfullmessage,10);
    }


    public String getPrice(int index){
        return getText(getPriceText(index),5) ;
    }
    public String getQuantity(int index){
        return getText(getQuantitiesText(index),5);
    }
    public String getTotal(int index){
        return getText(getTotalsText(index),5);
    }
    public List<String> getSelectedProducts(){
        System.out.println(getListOfElements(descriptions));
        return getListOfElements(descriptions) ;
    }


}
