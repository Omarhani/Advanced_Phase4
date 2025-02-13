package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class ProductsPage extends MethodHandles {
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    private final By products = By.xpath("//*[@class='single-products']") ;
    private final By addToCartButtons= By.xpath("//*[@class='single-products']//*[@class='overlay-content']//a") ;
    private final By getAddToCartButtons2 = By.xpath("//*[@class='productinfo text-center']//a");
    private final By clickOnContinue = By.xpath("//*[@class='modal-footer']//button") ;
    private final By viewCartButton = By.xpath("//*[@href='/view_cart']//u") ;
    private final By viewProductButtons = By.xpath("//*[@class='choose']") ;

    public void hoverOverElement(int index){
        hoverOverByIndex(products,index,5);
    }
    public void scrollToElement(int index){
        scrollToElementbyIndex(viewProductButtons,index,5);
    }
    public void clickOnAddToCart(int index){
        clickByIndex(addToCartButtons,20,index) ;
//        System.out.println(getText(addToCartButtons,5));
    }
    public void clickOnContinue(){
        click(clickOnContinue,10);
    }
    public ViewCartPage clickOnViewCartButton(){
        click(viewCartButton,5);
        return new ViewCartPage(driver) ;
    }

}
