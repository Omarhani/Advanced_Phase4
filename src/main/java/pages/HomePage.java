package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }
    private By contactUsLink = By.cssSelector("a[href='/contact_us']");


    public ContactUsPage clickOnContactUsLink() { // Added method to navigate to ContactUsPage
        click(contactUsLink, 5);
        return new ContactUsPage(driver);
    }

}
