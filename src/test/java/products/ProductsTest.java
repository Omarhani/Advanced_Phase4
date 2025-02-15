package products;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;
import static reader.ReadDataFromJson.dataModel;

public class ProductsTest extends BaseTests {

    @Test
    public void searchProducts() throws FileNotFoundException {
        LoginPage loginPage= homePage.ClickOnLoginLink();
        loginPage.loginFeature(dataModel().Login.ValidCredintails.Username,
                dataModel().Login.ValidCredintails.Password);
        ProductPage productPage =homePage.clickOnSearchLink();
        productPage.searchProducts(dataModel().SearchProducts.searchInput);
        String expectedResult= dataModel().SearchProducts.searchInput;
        String actualResult=productPage.getItemResult();
        assertTrue(expectedResult.toLowerCase().contains(actualResult.toLowerCase()));

    }


}
