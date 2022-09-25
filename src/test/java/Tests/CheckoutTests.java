package Tests;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    AuthenticationPage authenticationPage;
    CreateAnAccountPage createAnAccountPage;
    CartPage cartPage;
    HomePage homePage;
    ProductsPage productsPage;
    ItemDetailPage itemDetailPage;
    AddressesPage addressesPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
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
        shippingPage=new ShippingPage(driver);
        paymentPage=new PaymentPage(driver);
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
    @Link("http://prestashop.qatestlab.com.ua/en/")
    @Description("Actions for positive checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void actionsForPositiveCheckoutTest() {
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
        addressesPage.clickToProceedToCheckoutButtonOnAddressesPage();
        Assert.assertTrue(shippingPage.isShippingHeaderDisplayed());
        shippingPage.clickAgreeCheckBoxOnShippingPageButton();
        shippingPage.clickProceedToCheckoutButtonOnShippingPageButton();
        paymentPage.waitForPageLoaded();
        Assert.assertEquals(paymentPage.getWarningOnPaymentPageText(),"No payment modules have been installed.");
        homePage.clickToAccountButton();
        myAccountPage.clickToMyAddressesButton();
        myAccountPage.clickToDeleteAddressesButton();
        myAccountPage.clickToAlert();
    }
    @Test(groups = {"Negative"})
    @Link("http://prestashop.qatestlab.com.ua/en/")
    @Description("Actions for negative checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void actionsForNegativeCheckoutTest() {
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
        addressesPage.clickToProceedToCheckoutButtonOnAddressesPage();
        Assert.assertTrue(shippingPage.isShippingHeaderDisplayed());
        shippingPage.clickProceedToCheckoutButtonOnShippingPageButton();
        Assert.assertTrue(shippingPage.isErrorMessageDisplayed());
        Assert.assertEquals(shippingPage.getErrorMassageText(),"You must agree to the terms of service before continuing.");
        shippingPage.clickCloseErrorMessageButton();
        homePage.clickToAccountButton();
        myAccountPage.clickToMyAddressesButton();
        myAccountPage.clickToDeleteAddressesButton();
        myAccountPage.clickToAlert();
    }
}
