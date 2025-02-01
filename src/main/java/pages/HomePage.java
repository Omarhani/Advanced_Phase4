package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    }
    private By contactUsLink = By.cssSelector("a[href='/contact_us']");
    private By LoginLink = By.xpath("//*[@href='/login']");
    private By loginText = By.xpath("//*[contains(text(),' Logged in as ')]");

    public ContactUsPage clickOnContactUsLink() { // Added method to navigate to ContactUsPage
        click(contactUsLink, 5);
        return new ContactUsPage(driver);
    }



    public LoginPage ClickOnLoginLink() {
        click(LoginLink, 20);
        return new LoginPage(driver);
    }

    public String getLoggedUserName()
    {
        String loggedName= driver.findElement(loginText).getText();
        return loggedName;
    }





}
