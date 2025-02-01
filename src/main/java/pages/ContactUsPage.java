package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.io.File;
import java.time.Duration;

public class ContactUsPage extends MethodHandles {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private By contactUsButton = By.cssSelector("a[href='/contact_us']");
    private By getInTouchText = By.xpath("//h2[contains(., 'Get In Touch')]");
    private By nameField = By.name("name");
    private By emailField = By.name("email");
    private By subjectField = By.name("subject");
    private By messageField = By.id("message");
    private By fileUpload = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By successMessage = By.cssSelector("div.status.alert.alert-success");
    private By homeButton = By.cssSelector("a[href='/']");

    public void clickContactUs() {
        click(contactUsButton, 10);
    }

    public void verifyGetInTouchVisible() {
        myAssertEquals(isDisplayed(getInTouchText, 10), true);
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        sendKeys(nameField, name, 10);
        sendKeys(emailField, email, 10);
        sendKeys(subjectField, subject, 10);
        sendKeys(messageField, message, 10);
    }

    public void uploadFile(String fileName) {
        // Get absolute path from resources
        String filePath = new File("src/test/resources/" + fileName).getAbsolutePath();
        sendKeys(fileUpload, filePath, 10);
    }

    public void clickSubmit() {
        // Locate the submit button
        WebElement submitButton = driver.findElement(By.name("submit"));

        // Wait for the submit button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        // Scroll the submit button into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // Use JavaScript to click the submit button
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }


    public void handleAlert() {
        acceptAlert();
    }

    public void verifySuccessMessage() {
        String actualText = getText(successMessage, 10);
        myAssertEquals(actualText.contains("Success! Your details have been submitted successfully."), true);
    }

    public void navigateToHome() {
        click(homeButton, 10);
    }
}