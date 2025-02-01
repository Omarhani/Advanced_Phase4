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

//import static reader.ReadDataFromJson.dataModel;

public class LoginTest extends BaseTests {

WebDriver driver;

@Test
    public void Tc1_ValidLogin () throws FileNotFoundException {

        LoginPage  loginPage= homePage.ClickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredintails.Username,
               dataModel().Login.ValidCredintails.Password);
        String actualResult=homePage.getLoggedUserName();
        String expectedResult="Logged in as "+dataModel().Login.ValidCredintails.Username.split("@")[0];
        assertTrue(expectedResult.toLowerCase().contains(actualResult.toLowerCase()));
    }




}
