package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.LoginPage;
import pages.SignupPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class SignUpTest extends BaseTests {


    @Test

    public void testSignUp() throws FileNotFoundException {

        LoginPage loginpage = homePage.clickOnSignupLink();
        SignupPage signupPage = loginpage.clickOnSignupBtn(dataModel().Register.Name,dataModel().Register.Email);
         signupPage.clickOnTitle();
         signupPage.insertRegisterNameField(dataModel().SignUp.name);
         signupPage.insertPasswordField(dataModel().SignUp.password);
         signupPage.clickOnSignUpNewsLetterCheckBox();
         signupPage.clickOnSpecialOfferCheckBox();
         signupPage.insertFirstName(dataModel().SignUp.firstname);
         signupPage.insertLastname(dataModel().SignUp.lastname);
         signupPage.insertCompanyName(dataModel().SignUp.company);
         signupPage.insertAddressField(dataModel().SignUp.address);
         signupPage.insertAddress2Field(dataModel().SignUp.address2);
         signupPage.insertStateField(dataModel().SignUp.state);
         signupPage.insertCityField(dataModel().SignUp.city);
         signupPage.insertZipCodeField(dataModel().SignUp.zipcode);
         signupPage.insertMobileNumberField(dataModel().SignUp.mobilenumber);
        AccountCreatedPage accountCreatedPage = signupPage.clickOnCreateButton();
        Assert.assertTrue(accountCreatedPage.accountCreatedIsDisplayed());
        homePage = accountCreatedPage.clickOnContinueButton();
        Assert.assertTrue(homePage.logInisDisplayed());

    }



}
