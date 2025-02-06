package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class SignupPage extends MethodHandles {


    public SignupPage(WebDriver driver){

        super(driver);

    }

    private final By title = By.xpath("//input[@id='id_gender1']");

    private final By registerNameField = By.xpath("//input[@id='name']");

    private final By passwordField= By.xpath("//input[@id='password']");

    private final By signupnewletterCheckBox = By.xpath("//input[@name='newsletter']");

    private final By specialofferCheckBox = By.xpath("//input[@name='optin']");

    private final By firstNameField = By.xpath("//input[@id='first_name']");

    private final By lastNameField= By.xpath("//input[@id='last_name']");

    private final By companyField = By.xpath("//input[@id='company']");

    private final By addressField = By.xpath("//input[@id='address1']");

    private final By addressField2 = By.xpath("//input[@id='address2']");

    private final By stateField = By.xpath("//input[@id='state']");

    private final By cityField = By.xpath("//input[@id='city']");

    private final By zipcodeField = By.xpath("//input[@id='zipcode']");

    private final By mobileNumber = By.xpath("//input[@id='mobile_number']");

    private final By createAccountBtn = By.xpath("//button[text()='Create Account']");


    // actions


    public void clickOnTitle(){

        click(title,10);
    }

    public void insertRegisterNameField(String name ){
        clear(registerNameField,10);
        sendKeys(registerNameField,name,10);
    }


    public void insertPasswordField(String password){

        sendKeys(passwordField,password,10);
    }

    public void clickOnSignUpNewsLetterCheckBox(){

        clickWithActions(signupnewletterCheckBox,30);

    }

    public void clickOnSpecialOfferCheckBox(){

        clickWithActions(specialofferCheckBox,30);
    }

    public void insertFirstName(String firstname){

        sendKeys(firstNameField,firstname,10);
    }

    public void insertLastname(String lastname){

        sendKeys(lastNameField,lastname,10);
    }

    public void insertCompanyName(String companyname){

        sendKeys(companyField,companyname,10);
    }

    public void insertAddressField(String address){

        sendKeys(addressField,address,10);
    }

    public void insertAddress2Field(String address2){

        sendKeys(addressField2,address2,10);
    }

    public void insertStateField(String state){

        sendKeys(stateField,state,10);
    }

    public void insertCityField(String city){

        sendKeys(cityField,city,10);
    }

    public void insertZipCodeField(String zipcode){

        sendKeys(zipcodeField,zipcode,10);
    }

    public void insertMobileNumberField(String mobilenumber){

        sendKeys(mobileNumber,mobilenumber,10);
    }





    public AccountCreatedPage clickOnCreateButton(){

        clickWithActions(createAccountBtn,10);
        return new AccountCreatedPage(driver);
    }











}
