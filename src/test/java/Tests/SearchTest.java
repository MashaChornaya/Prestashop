package Tests;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    ItemDetailPage itemDetailPage;

    @BeforeClass(alwaysRun = true)
    public void initialise(){

        homePage=new HomePage(driver);
        productsPage=new ProductsPage(driver);
        itemDetailPage=new ItemDetailPage(driver);

    }
    @Test(groups = {"Regression"})
    @Description("Search product on home page")
    @Severity(SeverityLevel.NORMAL)
    public void searchProductTest() {
        homePage.setProductNameToSearchInput(PRODUCT_NAME);
        homePage.clickSearchButton();
        Assert.assertTrue(productsPage.isResultsMassageDisplayed());
        Assert.assertEquals(productsPage.getResultsMassageText(),"13 results have been found.");
    }
}

