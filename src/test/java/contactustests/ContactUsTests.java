package contactustests;

import base.BaseTests;
import data.DataModel;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class ContactUsTests extends BaseTests {

    @Test
    public void verifyContactUsFunctionality() throws FileNotFoundException {
        // Initialize pages with the inherited driver
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = homePage.clickOnContactUsLink(); // Navigate to ContactUsPage from HomePage

        // Load test data using dataModel() (same as LoginTest)
        DataModel data = dataModel();

        // Step 3: Verify initial home page URL
        homePage.myAssertContains(driver.getCurrentUrl(), "contact_us");

        // Step 4-11: Contact form process
        contactUsPage.verifyGetInTouchVisible(); // Verify "Get In Touch" is visible

        // Access ContactUs data directly from DataModel
        contactUsPage.fillContactForm(
                data.ContactUs.name,
                data.ContactUs.email,
                data.ContactUs.subject,
                data.ContactUs.message
        );

        contactUsPage.uploadFile(data.ContactUs.filePath); // Upload the file
        contactUsPage.clickSubmit(); // Click the submit button
        contactUsPage.handleAlert(); // Handle the alert (if any)
        contactUsPage.verifySuccessMessage(); // Verify the success message
        contactUsPage.navigateToHome(); // Navigate back to the home page

        // Final verification: Ensure the URL is correct after navigating home
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);
    }
}