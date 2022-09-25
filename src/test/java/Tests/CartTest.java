package Tests;

import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    AuthenticationPage authenticationPage;
    CreateAnAccountPage createAnAccountPage;
    CartPage cartPage;
    HomePage homePage;
    ProductsPage productsPage;
    ItemDetailPage itemDetailPage;
    AddressesPage addressesPage;
    MyAccountPage myAccountPage;


    @BeforeClass(alwaysRun = true)
    public void initialise(){
        authenticationPage=new AuthenticationPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        cartPage=new CartPage(driver);
        homePage=new HomePage(driver);
        productsPage=new ProductsPage(driver);
        itemDetailPage=new ItemDetailPage(driver);
        addressesPage=new AddressesPage(driver);
        myAccountPage=new MyAccountPage(driver);

    }

    final static String FIRST_NAME_FOR_ADDRESS_PAGE="Masha";
    final static String LAST_NAME_FOR_ADDRESS_PAGE="Chornaya";
    final static String ADDRESS_FOR_ADDRESS_PAGE="street New home 1 flat 1";
    final static String ZIP_POSTAL_CODE_FOR_ADDRESS_PAGE="12365";
    final static String CITY_FOR_ADDRESS_PAGE="New city";
    final static String HOME_PHONE_FOR_ADDRESS_PAGE="11234567890";
    final static String ADDRESS_TITLE_FOR_ADDRESS_PAGE="First address";

    @Test(groups = {"Smoke"})
    @Link("http://prestashop.qatestlab.com.ua/")
    @Description("Add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void addItemToCartTest() {
        homePage.clickToDressesSectionButton();
        productsPage.waitForPageLoaded();
        productsPage.clickCasualDressesButton();
        productsPage.openItemByName(ITEM_NAME);
        itemDetailPage.clickAddToCardButton();
        itemDetailPage.waitForAddToCartItemIconDisplayed();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Product successfully added to your shopping cart");
    }
    @Test(groups = {"Smoke"})
    @Link("http://prestashop.qatestlab.com.ua/")
    @Description("Remove product from cart")
    @Severity(SeverityLevel.CRITICAL)
    public void removeItemFromCartTest() {
        homePage.clickToDressesSectionButton();
        productsPage.waitForPageLoaded();
        productsPage.clickCasualDressesButton();
        productsPage.openItemByName(ITEM_NAME);
        itemDetailPage.clickAddToCardButton();
        itemDetailPage.waitForAddToCartItemIconDisplayed();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Product successfully added to your shopping cart");
        itemDetailPage.clickCloseWindowButton();
        itemDetailPage.clickCartButtonItemDetailsButton();
        cartPage.waitForPageLoaded();
        cartPage.clickTrashButton();
        cartPage.clickCartButton();
        Assert.assertTrue(cartPage.isAlertDisplayed());
    }
    @Test(groups = {"Regression"})
    @Link("http://prestashop.qatestlab.com.ua/")
    @Description("Actions on addresses page")
    @Severity(SeverityLevel.CRITICAL)
    public void actionsOnAddressesPageTestWithSelect() {
        homePage.clickToDressesSectionButton();
        productsPage.waitForPageLoaded();
        productsPage.clickCasualDressesButton();
        productsPage.openItemByName(ITEM_NAME);
        Assert.assertEquals(itemDetailPage.getItemName(),ITEM_NAME);
        Assert.assertEquals(itemDetailPage.getItemShortDescription(), ITEM_DESCRIPTION);
        itemDetailPage.clickAddToCardButton();
        itemDetailPage.clickCloseWindowButton();
        itemDetailPage.clickCartButtonItemDetailsButton();
        cartPage.waitForPageLoaded();
        cartPage.clickProceedToCheckoutButton();
        addressesPage.waitForPageLoaded();
        addressesPage.setFirstNameAddressPage(FIRST_NAME_FOR_ADDRESS_PAGE);
        addressesPage.setLastNameAddressPage(LAST_NAME_FOR_ADDRESS_PAGE);
        addressesPage.setAddress(ADDRESS_FOR_ADDRESS_PAGE);
        addressesPage.setZipPostalCode(ZIP_POSTAL_CODE_FOR_ADDRESS_PAGE);
        addressesPage.setCity(CITY_FOR_ADDRESS_PAGE);
        addressesPage.setHomePhone(HOME_PHONE_FOR_ADDRESS_PAGE);
        addressesPage.chooseStateWithSelect(5);
        addressesPage.setAddressTitle(ADDRESS_TITLE_FOR_ADDRESS_PAGE);
        addressesPage.clickSaveAddressButton();
        Assert.assertTrue(addressesPage.isAddressCompleteIconDisplayed());
        homePage.clickToAccountButton();
        myAccountPage.clickToMyAddressesButton();
        myAccountPage.clickToDeleteAddressesButton();
        myAccountPage.clickToAlert();
    }
}
