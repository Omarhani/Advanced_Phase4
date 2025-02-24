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


    private  final By contactUsLink = By.cssSelector("a[href='/contact_us']");
    private final  By LoginLink = By.xpath("//*[@href='/login']");
    private final By loginText = By.xpath("//*[contains(text(),' Logged in as ')]");
    private final By logoutLink = By.xpath("//*[@href='/logout']") ;
    private final By subscription = By.xpath("//h2[text()='Subscription']");
    private final By emailSubscriber = By.id("susbscribe_email");
    private final By arrowButton = By.xpath("//button[@id='subscribe']");
    private final By successfullMessage = By.xpath("//div[text()='You have been successfully subscribed!']");
    private final By cartShopping = By.xpath("//a[text()=' Cart']");

    private By productsLink = By.xpath("//*[@href='/products']");
    private final By signup_Link = By.xpath("//a[text()=' Signup / Login']");
    private final By logIn = By.xpath("//header[@id='header']//ul/li/a[text()=' Logged in as ']");

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
    public void clickOnLogout(){
        click(logoutLink,5);
    }
    public ProductsPage clickOnProductsLink(){
        click(productsLink,5);
        return new ProductsPage(driver);
    }

  
    public LoginPage clickOnSignupLink(){

        click(signup_Link,5);
        return new LoginPage(driver);
    }

    public boolean logInisDisplayed(){

        return isDisplayed(logIn,5);
    }



    public void successfullSubscription(String emailsubscriotion){
        insertEmailSubscription(emailsubscriotion);
        clickOnArrowButton();

    }

    public boolean successMessageDisplayed(){

        return isDisplayed(successfullMessage,10);

    }

    public CartPage clickOnCartMenu(){

        click(cartShopping,10);

        return new CartPage(driver);

    }




}
