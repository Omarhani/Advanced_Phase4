package testcasetest;

import base.BaseTests;
import data.DataModel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;
import utils.MethodHandles;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;

public class TestCasesTest extends BaseTests {

    @Test
    public void verifyTestCasesPageNavigation() throws FileNotFoundException {
        TestCasesPage testCasesPage = homePage.clickTestCasesLink();
        //  Verify that the Test Cases page is visible
        testCasesPage.verifyTestCasesPageVisible();

        myAssertEquals(driver.getCurrentUrl(), dataModel().testCasesURL);

        // Step 5: Navigate back to home page
        testCasesPage.navigateToHome();


    }
}