package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

    public class TestCasesPage extends MethodHandles {
        public TestCasesPage(WebDriver driver) {
            super(driver);
        }

        // Locators
      //  private By testCasesButton = By.cssSelector("a[href='/test_cases']");
        private By testCasesHeader = By.xpath("//h2[contains(., 'Test Cases')]");
        private By homeButton = By.cssSelector("a[href='/']");

        // Actions
     //   public void clickTestCases() {
        //    click(testCasesButton, 10);
      //  }

        public void verifyTestCasesPageVisible() {
            myAssertEquals(isDisplayed(testCasesHeader, 10), true);
        }

        public void navigateToHome() {
            click(homeButton, 10);
        }
    }

