package Tests;

import Pages.*;
import io.qameta.allure.Description;
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
    DressesPage dressesPage;
    ItemDetailPage itemDetailPage;
    AddressesPage addressesPage;

    @BeforeClass(alwaysRun = true)
    public void initialise(){
        authenticationPage=new AuthenticationPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        cartPage=new CartPage(driver);
        homePage=new HomePage(driver);
        dressesPage=new DressesPage(driver);
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


    @Test(groups = {"Smoke"})
    @Description("All actions that you can made on cart page")
    @Severity(SeverityLevel.CRITICAL)
    public void actionsOnCartPageTest() {
        //authenticationPage.setEmailForSignIn(EMAIL);
        //authenticationPage.setPasswordForSignIn(PASSWORD);
       // authenticationPage.clickSignButton();
        homePage.clickToSignInButton();
        createAnAccountPage.login(FIRST_NAME,PASSWORD,LAST_NAME);
        homePage.clickToDressesSectionButton();
        dressesPage.clickCasualDressesButton();
        dressesPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailPage.getItemName(),PRODUCT_NAME);
        Assert.assertEquals(itemDetailPage.getItemPrice(), "26,00 ₴");
        Assert.assertEquals(itemDetailPage.getItemShortDescription(), "100% cotton double printed dress. Black and white striped top and orange high waisted skater skirt bottom.");
        itemDetailPage.clickAddToCardButton();
        Assert.assertTrue(itemDetailPage.isAddToCartItemIconDisplayed());
        Assert.assertEquals(itemDetailPage.getAddToCartItemIconText(),"Товар был успешно добавлен в вашу корзину");

    }
    @Test(groups = {"Regression"})
    @Description("Actions on addresses page")
    @Severity(SeverityLevel.NORMAL)
    public void actionsOnAddressesPageTest() {
        homePage.clickToSignInButton();
        authenticationPage.setEmailForSignIn(EMAIL);
        authenticationPage.setPasswordForSignIn(PASSWORD);
        authenticationPage.clickSignButton();
        homePage.clickToDressesSectionButton();
        dressesPage.clickCasualDressesButton();
       // dressesPage.openItemByName(PRODUCT_NAME);
        dressesPage.clickItem1Button();
        Assert.assertEquals(itemDetailPage.getItemName(),PRODUCT_NAME);
        Assert.assertEquals(itemDetailPage.getItemPrice(), "26,00 ₴");
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
        addressesPage.clickStateButton();
        addressesPage.setAddressTitle(ADDRESS_TITLE_FOR_ADDRESS_PAGE);
        addressesPage.clickSaveAddressButton();
        Assert.assertTrue(addressesPage.isAddressCompleteIconDisplayed());
    }
}
