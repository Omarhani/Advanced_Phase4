package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class CartTest extends BaseTests {

    @Test

    public void testCartSubscription() throws FileNotFoundException {

        CartPage cartPage = homePage.clickOnCartMenu();
        cartPage.verifySubcriptionInCart(dataModel().CartMail.emailsubscription);
        Assert.assertTrue(cartPage.successfulMessageIsDisplayed());
    }



}
