package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

import java.util.List;

public class ViewCartPage extends MethodHandles {
    public ViewCartPage(WebDriver driver){
        super(driver);
    }
    private final By descriptions = By.xpath("//tbody//tr//*[@class='cart_description']//h4//a") ;
    private final By prices = By.xpath("//tbody//tr//*[@class='cart_price']//p") ;
    private final By quantities = By.xpath("//tbody//tr//*[@class='cart_quantity']//button") ;
    private final By total = By.xpath("//tbody//tr//*[@class='cart_total']//p") ;

    public String getDescription(int index){
        return getTextByIndex(descriptions,5,index);
    }
    public String getPrice(int index){
        return getTextByIndex(prices,5,index);
    }
    public String getQuantity(int index){
        return getTextByIndex(quantities,5,index);
    }
    public String getTotal(int index){
        return getTextByIndex(total,5,index);
    }
    public List<String> getSelectedProducts(){
        System.out.println(getListOfElements(descriptions));
       return getListOfElements(descriptions) ;
    }


}
