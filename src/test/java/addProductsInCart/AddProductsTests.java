package addProductsInCart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ViewCartPage;

import java.io.FileNotFoundException;
import java.util.List;

import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;

public class AddProductsTests extends BaseTests {
    @Test
    public void testSuccessfulAddToCart() throws InterruptedException, FileNotFoundException {
       ProductsPage productsPage = homePage.clickOnProductsLink();
       //Product 1
       productsPage.addProductToCart(1);
       productsPage.clickOnContinue();

       //Product 2
      productsPage.addProductToCart(2);
        ViewCartPage viewCartPage = productsPage.clickOnViewCartButton();

//        Verify both products are added to Cart
       List<String> selctedProducts =  viewCartPage.getSelectedProducts();
       Assert.assertTrue(selctedProducts.contains(dataModel().Products.Item1.description)
                       &&selctedProducts.contains(dataModel().Products.Item2.Description),"Assertion Fails ");

//        Verify their prices, quantity and total price
        myAssertEquals(viewCartPage.getPrice(1),dataModel().Products.Item1.Price);
        myAssertEquals(viewCartPage.getQuantity(1),dataModel().Products.Item1.Quantity);
        myAssertEquals(viewCartPage.getTotal(1),dataModel().Products.Item1.Total);

//        Verify their prices, quantity and total price
        myAssertEquals(viewCartPage.getPrice(2),dataModel().Products.Item2.Price);
        myAssertEquals(viewCartPage.getQuantity(2),dataModel().Products.Item2.Quantity);
        myAssertEquals(viewCartPage.getTotal(2),dataModel().Products.Item2.Total);
    }
}
