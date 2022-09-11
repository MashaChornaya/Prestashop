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

    @BeforeClass(alwaysRun = true)
    public void initialise(){
        authenticationPage=new AuthenticationPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        cartPage=new CartPage(driver);
        homePage=new HomePage(driver);
        productsPage=new ProductsPage(driver);
        itemDetailPage=new ItemDetailPage(driver);
        addressesPage=new AddressesPage(driver);
    }

    final static String FIRST_NAME_FOR_ADDRESS_PAGE="Masha";
    final static String LAST_NAME_FOR_ADDRESS_PAGE="Chornaya";
    final static String ADDRESS_FOR_ADDRESS_PAGE="street New home 1 flat 1";
    final static String ZIP_POSTAL_CODE_FOR_ADDRESS_PAGE="12365";
    final static String CITY_FOR_ADDRESS_PAGE="New city";
    final static String HOME_PHONE_FOR_ADDRESS_PAGE="11234567890";
    final static String ADDRESS_TITLE_FOR_ADDRESS_PAGE="First address";
    final static String PRODUCT_NAME_FOR_REMOVE_TEST="Blouse";


    @Test(groups = {"Smoke"})
    @Link("http://prestashop.qatestlab.com.ua/en/")
    @Description("All actions that you can made on cart page")
    @Severity(SeverityLevel.CRITICAL)
    public void productDetailsTest() {

        homePage.clickToSignInButton();
        authenticationPage.authentication(EMAIL,PASSWORD);
        authenticationPage.clickSignButton();
        homePage.clickToDressesSectionButton();
        productsPage.clickCasualDressesButton();
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailPage.getItemName(),PRODUCT_NAME);
        Assert.assertEquals(itemDetailPage.getItemPrice(), "31,20 ₴");
        Assert.assertEquals(itemDetailPage.getItemShortDescription(), "100% cotton double printed dress. Black and white striped top and orange high waisted skater skirt bottom.");
        itemDetailPage.clickAddToCardButton();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Товар был успешно добавлен в вашу корзину");

    }
    @Test(groups = {"Smoke"})
    @Link("http://prestashop.qatestlab.com.ua/en/")
    @Description("Add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void addItemToCartTest() {
        homePage.clickToItemName();
       //productsPage.openItemByName(PRODUCT_NAME);
        itemDetailPage.clickAddToCardButton();
        itemDetailPage.waitForAddToCartItemIconDisplayed();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Товар был успешно добавлен в вашу корзину");
    }
    @Test(groups = {"Smoke"})
    @Link("http://prestashop.qatestlab.com.ua/en/")
    @Description("Remove product from cart")
    @Severity(SeverityLevel.CRITICAL)
    public void removeItemFromCartTest() {
        homePage.clickToItemName();
        //productsPage.openItemByName(PRODUCT_NAME);
        itemDetailPage.clickAddToCardButton();
        itemDetailPage.waitForAddToCartItemIconDisplayed();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Товар был успешно добавлен в вашу корзину");
        itemDetailPage.clickCloseWindowButton();
        itemDetailPage.clickCartButtonItemDetailsButton();
        cartPage.clickTrashButton();
        cartPage.waitForCartValueTextIsDisplayed();
        itemDetailPage.clickCartButtonItemDetailsButton();
      Assert.assertEquals(cartPage.getCartValue(),"0 product");
    }

    @Test(groups = {"Regression"})
    @Link("http://prestashop.qatestlab.com.ua/en/")
    @Description("Actions on addresses page")
    @Severity(SeverityLevel.NORMAL)
    public void actionsOnAddressesPageTestWithSelect() {
        homePage.clickToSignInButton();
        authenticationPage.setEmailForSignIn(EMAIL);
        authenticationPage.setPasswordForSignIn(PASSWORD);
        authenticationPage.clickSignButton();
        homePage.clickToDressesSectionButton();
        productsPage.clickCasualDressesButton();
        // dressesPage.openItemByName(PRODUCT_NAME);
        productsPage.clickItem1Button();
        Assert.assertEquals(itemDetailPage.getItemName(),PRODUCT_NAME);
        Assert.assertEquals(itemDetailPage.getItemPrice(), "31,20 ₴");
        Assert.assertEquals(itemDetailPage.getItemShortDescription(), "100% cotton double printed dress. Black and white striped top and orange high waisted skater skirt bottom.");
        itemDetailPage.clickAddToCardButton();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Товар был успешно добавлен в вашу корзину");
        itemDetailPage.clickCheckOutButton();
        cartPage.clickProceedToCheckoutButton();
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
    }
}
