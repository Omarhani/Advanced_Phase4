package signup;

import base.BaseTests;
import data.DataModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class SignUpTest extends BaseTests {


    @Test

    public void testSignUp() throws FileNotFoundException {


        LoginPage loginpage = homePage.clickOnSignupLink();

        if (dataModel().Register != null) {
            loginpage.insertEmail(dataModel().Register.Name);
            loginpage.insertName(dataModel().Register.Email);
        } else {
            throw new RuntimeException("Register data is missing in the JSON file.");
        }
        loginpage.insertName(dataModel().Register.Name);
         loginpage.insertEmail(dataModel().Register.Email);
         SignupPage signupPage = loginpage.clickOnSignupBtn();
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


    }

    @Test(dependsOnMethods = "testSignUp")


    public void  testDisplayedLoggedUserName(){


      homePage = accountCreatedPage.clickOnContinueButton();

        Assert.assertTrue(homePage.logInisDisplayed());



    }


}
