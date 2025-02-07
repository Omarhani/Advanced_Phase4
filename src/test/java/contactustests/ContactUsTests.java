package contactustests;

import base.BaseTests;
import data.DataModel;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.MethodHandles;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;

public class ContactUsTests extends BaseTests {

    @Test
    public void verifyContactUsFunctionality() throws FileNotFoundException {
        // Navigate to the Contact Us page from the HomePage.
        // Assumes that 'homePage' is already initialized in BaseTests.
        ContactUsPage contactUsPage = homePage.clickOnContactUsLink();

        // Step 4: Verify that "Get In Touch" is visible on the Contact Us page
        contactUsPage.verifyGetInTouchVisible();

        // Step 5-8: Fill out the contact form with test data
        contactUsPage.fillContactForm(
                dataModel().ContactUs.name,
                dataModel().ContactUs.email,
                dataModel().ContactUs.subject,
                dataModel().ContactUs.message
        );

        // Step 9: Upload the file specified in the test data
        contactUsPage.uploadFile(dataModel().ContactUs.filePath);

        // Step 10: Click the submit button to send the form
        contactUsPage.clickSubmit();

        // Step 11: Handle any alert that may appear after submission
        contactUsPage.handleAlert();

        // Step 12: Verify that the success message is displayed
        String actualSuccessMessage = contactUsPage.verifySuccessMessage();
        String expectedSuccessMessage = "Success! Your details have been submitted successfully."; // Update as required
        MethodHandles.myAssertEquals(actualSuccessMessage, expectedSuccessMessage);

        // Step 13: Navigate back to the Home Page
        contactUsPage.navigateToHome();
    }
}
