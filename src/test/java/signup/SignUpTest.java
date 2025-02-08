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
         signupPage.completeSignUpForm(dataModel().SignUp.name,dataModel().SignUp.password,dataModel().SignUp.firstname,
                 dataModel().SignUp.lastname,dataModel().SignUp.company,dataModel().SignUp.address,dataModel().SignUp.address2,
                 dataModel().SignUp.state,dataModel().SignUp.city,dataModel().SignUp.zipcode,dataModel().SignUp.mobilenumber);
        AccountCreatedPage accountCreatedPage = signupPage.clickOnCreateButton();
        Assert.assertTrue(accountCreatedPage.accountCreatedIsDisplayed());
        homePage = accountCreatedPage.clickOnContinueButton();
        Assert.assertTrue(homePage.logInisDisplayed());

    }



}
