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
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        // Load test data using dataModel() (same as LoginTest)
        DataModel data = dataModel();

        // Step 3: Verify initial home page URL
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);

        // Step 4-11: Contact form process
        contactUsPage.clickContactUs();
        contactUsPage.verifyGetInTouchVisible();

        // Access ContactUs data directly from DataModel
        contactUsPage.fillContactForm(
                data.ContactUs.name,
                data.ContactUs.email,
                data.ContactUs.subject,
                data.ContactUs.message
        );

        contactUsPage.uploadFile(data.ContactUs.filePath);
        contactUsPage.clickSubmit();
        contactUsPage.handleAlert();
        contactUsPage.verifySuccessMessage();
        contactUsPage.navigateToHome();

        // Final verification
        homePage.myAssertEquals(driver.getCurrentUrl(), data.URL);
    }
}