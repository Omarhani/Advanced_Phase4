package login;

import base.BaseTests;
import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;
import static reader.ReadDataFromJson.dataModel;

public class LoginTest extends BaseTests {


    @Test(priority = 1)
    public void Tc1InValidLoginUsername () throws FileNotFoundException {

        LoginPage loginPage = homePage.ClickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.InvalidCredintails.InvalidUsername.Username,
                dataModel().Login.InvalidCredintails.InvalidUsername.Password);
        String actualResult = loginPage.GetValidationMessage();
        String expectedResult = "Your email or password is incorrect!";
        assertTrue(expectedResult.contains(actualResult));
    }

    @Test(priority = 2)
    public void Tc2InValidLoginPassword () throws FileNotFoundException {

        LoginPage loginPage1 = homePage.ClickOnLoginLink();
        loginPage1.loginFeature(dataModel().Login.InvalidCredintails.InvalidPassword.Username,
                dataModel().Login.InvalidCredintails.InvalidPassword.Password);
        String actualResult = loginPage1.GetValidationMessage();
        String expectedResult = "Your email or password is incorrect!";
        assertTrue(expectedResult.contains(actualResult));
    }

    @Test(priority = 3)
    public void Tc3ValidLogin () throws FileNotFoundException {

        LoginPage  loginPage= homePage.ClickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredintails.Username,
                dataModel().Login.ValidCredintails.Password);
    }
    @Test
    public void CheckValidLogin () throws FileNotFoundException {

        LoginPage  loginPage= homePage.ClickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredintails.Username,
               dataModel().Login.ValidCredintails.Password);
        String actualResult=homePage.getLoggedUserName();
        String expectedResult="Logged in as "+dataModel().Login.ValidCredintails.Username.split("@")[0];
        assertTrue(expectedResult.toLowerCase().contains(actualResult.toLowerCase()));
    }

}



