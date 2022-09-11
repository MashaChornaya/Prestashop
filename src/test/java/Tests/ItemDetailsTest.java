package Tests;

import Pages.ItemDetailPage;
import Pages.AuthenticationPage;
import Pages.ProductsPage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ItemDetailsTest extends BaseTest {
    ItemDetailPage itemDetailPage;
    ProductsPage productsPage;
    AuthenticationPage authenticationPage;


    @BeforeClass (alwaysRun = true)
    public void initialise(){

        itemDetailPage=new ItemDetailPage(driver);
        productsPage=new ProductsPage(driver);
        authenticationPage=new AuthenticationPage(driver);

    }
    @Test(groups={"Regression"},dataProvider = "inventoryItemsTestData")
    @Description("Check item name, price and description")
    @Severity(SeverityLevel.NORMAL)
    @Link("http://prestashop.qatestlab.com")

    public void inventoryItemsTest(String itemName, String itemPrice, String itemShortDescription) {
        homePage.clickToSignInButton();
        authenticationPage.authentication(EMAIL, PASSWORD);
        authenticationPage.clickSignButton();
        homePage.clickToDressesSectionButton();
        productsPage.clickCasualDressesButton();
        productsPage.openItemByName(itemName);
        Assert.assertEquals(itemDetailPage.getItemName(), itemName);
        Assert.assertEquals(itemDetailPage.getItemPrice(), itemPrice);
        Assert.assertEquals(itemDetailPage.getItemShortDescription(), itemShortDescription);
    }
    @DataProvider()
    public Object[][] inventoryItemsTestData(){
        return new Object[][]{
                {"Printed Dress","31,20","100% cotton double printed dress. Black and white striped top and orange high waisted skater skirt bottom."},
                {"Dress","61,19","Printed evening dress with straight sleeves with black thin waist belt and ruffled linings."},
                {"Printed Summer Dress","36,60","Sleeveless knee-length chiffon dress. V-neckline with elastic under the bust lining."}
        };
    }
}
