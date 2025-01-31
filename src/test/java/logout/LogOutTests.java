package logout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LogOutTests extends BaseTests {
    @Test
    public void testLogout() throws FileNotFoundException {
        LoginPage loginPage= homePage.ClickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredintails.Username,
                dataModel().Login.ValidCredintails.Password);
        homePage.clickOnLogout();
        String expectedResult = "https://www.automationexercise.com/login";
        String actualResult = loginPage.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult,"url doesn't match");
    }
}
