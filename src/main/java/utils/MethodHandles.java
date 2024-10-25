package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MethodHandles {
    protected WebDriver driver;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
}
