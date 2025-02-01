package contactustests;

import base.BaseTests;
import data.DataModel;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class ContactUsTests extends BaseTests {

    @Test
    public void verifyContactUsFunctionality() throws FileNotFoundException {
        // Navigate to the Contact Us page from the HomePage.
        // Assumes that 'homePage' is already initialized in BaseTests.
        ContactUsPage contactUsPage = homePage.clickOnContactUsLink();

        // Load test data from JSON using dataModel()
        DataModel data = dataModel();

        // Step 3: Verify that the current URL contains "contact_us"
        homePage.myAssertContains(driver.getCurrentUrl(), "contact_us");

        // Step 4: Verify that "Get In Touch" is visible on the Contact Us page
        contactUsPage.verifyGetInTouchVisible();

        // Step 5-8: Fill out the contact form with test data
        contactUsPage.fillContactForm(
                data.ContactUs.name,
                data.ContactUs.email,
                data.ContactUs.subject,
                data.ContactUs.message
        );

        // Step 9: Upload the file specified in the test data
        contactUsPage.uploadFile(data.ContactUs.filePath);

        // Step 10: Click the submit button to send the form
        contactUsPage.clickSubmit();

        // Step 11: Handle any alert that may appear after submission
        contactUsPage.handleAlert();

        // Step 12: Verify that the success message is displayed
        contactUsPage.verifySuccessMessage();

        // Step 13: Navigate back to the Home Page
        contactUsPage.navigateToHome();

        // Final verification: Ensure that the home page URL matches the expected URL from test data
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);
    }
}
