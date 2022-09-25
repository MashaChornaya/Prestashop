package Tests;

import Pages.CartPage;
import Pages.ItemDetailPage;
import Pages.AuthenticationPage;
import Pages.ProductsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ItemDetailsTest extends BaseTest {
    ItemDetailPage itemDetailPage;
    ProductsPage productsPage;
    AuthenticationPage authenticationPage;
    CartPage cartPage;

    @BeforeClass (alwaysRun = true)
    public void initialise(){

        itemDetailPage=new ItemDetailPage(driver);
        productsPage=new ProductsPage(driver);
        authenticationPage=new AuthenticationPage(driver);
        cartPage=new CartPage(driver);

    }
    @Test(groups={"Regression"},dataProvider = "inventoryItemsTestOnProductPageData")
    @Description("Check item name, price and description")
    @Severity(SeverityLevel.NORMAL)
    @Link("http://prestashop.qatestlab.com.ua/")
    public void inventoryItemsTestOnProductPage(String itemName, String itemPrice) {
        homePage.clickToDressesSectionButton();
        productsPage.clickCasualDressesButton();
        Assert.assertTrue(productsPage.getProductName(itemName),"Wrong name");
        Assert.assertTrue(productsPage.getProductPrice(itemPrice),"Wrong price");
    }
    @DataProvider()
    public Object[][] inventoryItemsTestOnProductPageData(){
        return new Object[][]{
               {"Printed Dress","31,20"},
                {"Printed Chiffon Dress","24,60"},
                {"Red Dress","180,00"},
                {"White Crisscross Back Shift Dress","720,00"},
                {"Black Chiffon Dress","816,00"},
                {"Dark Grey Sheath Dress","660,00"},
                {"Elegant Beige  Dress","576,00"},
                {"Pink Skater Dress","696,00"},
                {"Dark Blue Sheath Dress","840,00"},
        };
    }

    @Test(groups={"Regression"})
    @Description("Check item name, price and description")
    @Severity(SeverityLevel.NORMAL)
    @Link("http://prestashop.qatestlab.com.ua/")
    public void inventoryItemsTestOnItemDetailsPage(){
        homePage.clickToDressesSectionButton();
        productsPage.clickCasualDressesButton();
        productsPage.waitForPageLoaded();
        productsPage.openItemByName(ITEM_NAME);
        Assert.assertEquals(itemDetailPage.getItemNameQuick(), ITEM_NAME);
        Assert.assertEquals(itemDetailPage.getItemPriceQuick(), ITEM_PRICE);
        Assert.assertEquals(itemDetailPage.getItemShortDescriptionQuick(), ITEM_DESCRIPTION);
    }

}
