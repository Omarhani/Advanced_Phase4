package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductPage extends MethodHandles {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By searchProducts = By.xpath("//*[@id='search_product']");
    private By allProducts = By.xpath("(//*[contains(text(),'All Products')])[2]");

    private By searchIcon = By.xpath("//*[@id='submit_search']");
    // private  By searchItemResult=By.xpath("//*[@class='product-overlay']");
    private By searchItemResult = By.cssSelector(".product-overlay");


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

    private By searchItem(String search) {
        return By.xpath("//div[@class='overlay-content']//p[contains(text(),'" + search + "')]");
    }

    public void searchProducts(String searchData) {
        isDisplayed(allProducts, 10);
        sendKeys(searchProducts, searchData, 20);
        click(searchIcon, 20);
        moveToElement(searchItemResult,20);
    }

    public String getItemResult(String searchProduct) {
        return getText(searchItem(searchProduct),5);
    }

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
    public CartPage clickOnViewCartButton(){
        click(viewCartButton,5);
        return new CartPage(driver) ;
    }



}
