package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.FileNotFoundException;
import static reader.ReadDataFromJson.dataModel;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnSignInAndLoginLink();
        loginPage.loginFeature(
                dataModel().Login.ValidCredintails.Username,
                dataModel().Login.ValidCredintails.Password);
    }
}
