package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MethodHandles {
    protected WebDriver driver;

    static ExtentReports extent;

    static ExtentTest test;
    private WebDriverWait wait;
    Select select;
    Actions actions;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }

    private void setSteps() {
        test.info(getMethodName());
    }

    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '7px solid red'", element);
    }

    private void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
    }
    private void explicitWait(WebElement webElement, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement)));
    }

    protected void invisibilityOf(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOf(webElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)));
    }

    protected void selectByVisibleText(By locator, int time, String text) {
        select = new Select(webElement(locator));
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                select.selectByVisibleText(text);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByValue(By locator, int time, String value) {
        select = new Select(webElement(locator));
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                select.selectByValue(value);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByIndex(By locator, int time, int index) {
        select = new Select(webElement(locator));
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }


    protected void click(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).click();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void submit(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).submit();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected Point getLocation(By locator, int time) {
        Point point = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                point = webElement(locator).getLocation();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return point;
    }

    protected void clear(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).clear();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected boolean isDisplayed(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isDisplayed();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected boolean isSelected(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isSelected();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected boolean isEnabled(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isEnabled();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected String getText(By locator, int time) {
        String text = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                text = webElement(locator).getText();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return text;
    }

    protected void sendKeys(By locator, String text, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).sendKeys(text);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    protected void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    protected void getTextAlert() {
        driver.switchTo().alert().getText();
    }

    protected void switchToFrame(String nameOrID) {
        driver.switchTo().frame(nameOrID);
    }

    protected void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    protected void switchToParent() {
        driver.switchTo().parentFrame();
    }

    protected void clickWithActions(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.click(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void doubleClick(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.doubleClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void contextClick(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.contextClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void release(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.release(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void moveToElement(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.moveToElement(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }
    protected void clickAndHold(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                actions.clickAndHold(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void dragAndDrop(By src, By target, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(src, time);
                explicitWait(target, time);
                setSteps();
                addBorderToElement(driver, webElement(src));
                addBorderToElement(driver, webElement(target));
                actions.dragAndDrop(webElement(src), webElement(target)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void release() {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                setSteps();
                actions.release().build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clickWithActions() {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                setSteps();
                actions.click().build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }
    protected String getCurrentURL() {
        String url = null;
        for (int i = 0; i < 5; i++) {
            try {
                setSteps();
                url = driver.getCurrentUrl();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return url;
    }
    public WebElement getWebElementByIndex(By locator , int index){
        return driver.findElements(locator).get(index-1) ;
    }
    protected void clickByIndex(By locator , int time , int index ){
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( getWebElementByIndex(locator,index)  , time);
                addBorderToElement(driver, getWebElementByIndex(locator,index));
                setSteps();
                getWebElementByIndex(locator, index).click();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }
    protected void hoverOverByIndex(By locator , int index , int time ){
        actions =  new Actions(driver) ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait(getWebElementByIndex(locator,index) , time);
                addBorderToElement(driver, getWebElementByIndex(locator,index));
                setSteps();
                actions.moveToElement(getWebElementByIndex(locator,index)).build().perform();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }

    }
    protected void scrollToElementbyIndex(By locator ,int index , int time){
        explicitWait(getWebElementByIndex(locator,index) ,time );
        addBorderToElement(driver, getWebElementByIndex(locator,index));
        setSteps();
        actions = new Actions(driver) ;
        actions.scrollToElement(getWebElementByIndex(locator , index)).build().perform();
    }
    protected String getTextByIndex(By locator, int time , int index) {
        String text = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(getWebElementByIndex(locator,index), time);
                setSteps();
                addBorderToElement(driver, getWebElementByIndex(locator,index));
                text = getWebElementByIndex(locator,index).getText();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return text;
    }

    protected List<String> getListOfElements(By locator){
        List<WebElement> elements = driver.findElements(locator);
        List<String> list = new ArrayList<>() ;
            for (WebElement element :elements  ){
                list.add(element.getText())  ;
            }
            return list ;
    }

    public static void myAssertEquals(Object actualResult, Object expectedResult) {
        test.info(MarkupHelper
                .createLabel("------------------- Actual Result -------------------", ExtentColor.TEAL));
        test.info(actualResult.toString());

        test.info(MarkupHelper
                .createLabel("------------------- Expected Result -------------------", ExtentColor.TEAL));
        test.info(expectedResult.toString());

        assertEquals(actualResult, expectedResult);
    }

    public void myAssertContains(String currentUrl, String contactUs) {
    }
}
