package signUpWithExistingEmail;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;

public class SignUpWithExistingEmailTests extends BaseTests {
    @Test
    public void testUnSuccessfulSignUp() throws FileNotFoundException {
        LoginPage loginpage = homePage.clickOnSignupLink();
        SignupPage signupPage =
                loginpage.clickOnSignupBtn(
                        dataModel().Register.Name,
                        dataModel().Register.Email
                );
        String actualResult = signupPage.getValidationMessage();
        String expectedResult = dataModel().ValidationMessage;
        myAssertEquals(actualResult,expectedResult);
    }
}
