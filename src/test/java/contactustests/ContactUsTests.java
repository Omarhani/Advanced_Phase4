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
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        // Load test data safely
        DataModel data = dataModel();
        DataModel.ContactUs contactData = data.ContactUs;

        // Step 3: Verify initial home page URL
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);

        // Step 4-11: Contact form process
        contactUsPage.clickContactUs();
        contactUsPage.verifyGetInTouchVisible();

        contactUsPage.fillContactForm(
                contactData.name,
                contactData.email,
                contactData.subject,
                contactData.message
        );

        contactUsPage.uploadFile(contactData.filePath);
        contactUsPage.clickSubmit();
        contactUsPage.handleAlert();
        contactUsPage.verifySuccessMessage();
        contactUsPage.navigateToHome();

        // Final verification
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);
    }
}