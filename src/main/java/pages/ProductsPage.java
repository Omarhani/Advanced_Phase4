package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class ProductsPage extends MethodHandles {
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    private  By getProduct(int index){
        return By.xpath("//*[@class='col-sm-4']["+index+"]//*[@class='single-products']");
    }
    private final By addToCartButtons= By.xpath("//*[@class='single-products']//*[@class='overlay-content']//a");
    private By getAddToCartButton(int index){
        return By.xpath("//*[@class='col-sm-4']["+index+"]//*[@class='single-products']//*[@class='overlay-content']//a")  ;
    }
    private final By getAddToCartButtons2 = By.xpath("//*[@class='productinfo text-center']//a");
    private final By clickOnContinue = By.xpath("//*[@class='modal-footer']//button") ;
    private final By viewCartButton = By.xpath("//*[@href='/view_cart']//u") ;
    private By getProductButton(int index){
       return By.xpath("//*[@class='col-sm-4']["+index+"]//*[@class='choose']");
    } ;

    private void hoverOverElement(int index){
         moveToElement(getProduct(index),5);
    }
    private void scrollToElement(int index){
        moveToElement(getProductButton(index),5);
    }
    private void clickOnAddToCart(int index){
        click(getAddToCartButton(index),5);
//        System.out.println(getText(addToCartButtons,5));
    }

    public void addProductToCart( int index){
        scrollToElement(index);
        hoverOverElement(index);
        clickOnAddToCart(index);
    }
    public void clickOnContinue(){
        click(clickOnContinue,10);
    }
    public ViewCartPage clickOnViewCartButton(){
        click(viewCartButton,5);
        return new ViewCartPage(driver) ;
    }

}
