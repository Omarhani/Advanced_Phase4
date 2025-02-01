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
        // Initialize pages with the inherited driver
        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        // Load test data using dataModel()
        DataModel data = dataModel();

        // Step 1: Verify initial home page URL
        homePage.myAssertContains(driver.getCurrentUrl(), data.URL);

        // Step 2: Navigate to Test Cases page
        testCasesPage = homePage.clickTestCasesLink(); // Use HomePage to navigate to TestCasesPage

        // Step 3: Verify Test Cases page is visible
        testCasesPage.verifyTestCasesPageVisible();

        // Step 4: Verify Test Cases page URL
        homePage.myAssertContains(driver.getCurrentUrl(), data.testCasesURL); // Ensure testCasesURL is added to DataModel

        // Step 5: Navigate back to home page
        testCasesPage.navigateToHome();

        // Step 6: Verify home page URL
        homePage.myAssertContains(driver.getCurrentUrl(), data.URL);
    }
}