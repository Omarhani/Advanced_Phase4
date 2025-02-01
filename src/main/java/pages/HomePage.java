package pages;

import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By testCasesLink = By.cssSelector("a[href='/test_cases']"); // Locator for Test Cases link

    // Methods
    public TestCasesPage clickTestCasesLink() {
        click(testCasesLink, 10); // Click on the Test Cases link
        return new TestCasesPage(driver); // Return a new instance of TestCasesPage
    }
}