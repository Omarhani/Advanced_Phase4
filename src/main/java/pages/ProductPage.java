package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductPage extends MethodHandles {

    public ProductPage(WebDriver driver)
    {super(driver);}

    private By searchProducts= By.xpath("//*[@id='search_product']");
    private By allProducts=By.xpath("(//*[contains(text(),'All Products')])[2]");

    private By searchIcon=By.xpath("//*[@id='submit_search']");
   // private  By searchItemResult=By.xpath("//*[@class='product-overlay']");
    private By searchItemResult=By.cssSelector(".product-overlay");

    public void searchProducts(String searchData)
    {   isDisplayed(allProducts,10);
        sendKeys(searchProducts,searchData,20);
        click(searchIcon,20);
        isDisplayed(searchItemResult,40);

    }
public String getItemResult()
{
    return driver.findElement(searchItemResult).findElement(By.tagName("p")).getText();
}


}
