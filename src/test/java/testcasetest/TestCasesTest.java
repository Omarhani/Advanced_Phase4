package testcasetest;
import base.BaseTests;
import data.DataModel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;
import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class TestCasesTest extends BaseTests {

    @Test
    public void verifyTestCasesPageNavigation() throws FileNotFoundException {
        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        DataModel data = dataModel();

        // Verify initial home page
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);

        // Navigate to Test Cases page
        testCasesPage.clickTestCases();

        // Verify Test Cases page
        testCasesPage.verifyTestCasesPageVisible();
        homePage.myAssertEquals(driver.getCurrentUrl(), data.testCasesURL); // Add this URL to DataModel

        // Return to home
        testCasesPage.navigateToHome();
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);
    }
}