package subscription;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class SubscriptionTest extends BaseTests {

    @Test

    public void testSubscription() throws FileNotFoundException {

        homePage.successfullSubscription(dataModel().SubscriptionMail.emailsubscription);

        Assert.assertTrue(homePage.successMessageDisplayed());
    }
}
