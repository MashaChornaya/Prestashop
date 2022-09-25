package Pages;

import Utils.AllureUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Log4j2

public class AddressesPage extends BasePage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }


    private final static By addressPageHeader= By.cssSelector(".info-title");
    private final static By firstNameAddressPage= By.xpath("//input[@id='firstname']");
    private final static By lastNameAddressPage= By.xpath("//input[@id='lastname']");
    private final static By address= By.xpath("//input[@id='address1']");
    private final static By zipPostalCode= By.xpath("//input[@id='postcode']");
    private final static By city= By.xpath("//input[@id='city']");
    private final static By homePhone= By.xpath("//input[@id='phone']");
    private final static By addressTitle= By.xpath("//input[@id='alias']");
    private final static By saveAddressButton= By.xpath("//button[@id='submitAddress']");
    private final static By addressCompleteIcon= By.xpath("//h3[ text()='Your billing address']");
    private final static By stateSelect=By.cssSelector("#id_state");
    private final static By proceedToCheckoutOnAddressesPage=By.xpath("//button[@name='processAddress']");


    @Override
    public void waitForPageLoaded() {
        log.info("Wait for create page loaded");
        waitForElementDisplayed(addressPageHeader);
    }
    public void setFirstNameAddressPage(String firstNameForAddressPage) {
        log.info(String.format("Set first name = %s from Cart Test ", firstNameForAddressPage));
        driver.findElement(firstNameAddressPage).sendKeys(firstNameForAddressPage);
    }
    public void setLastNameAddressPage(String lastNameForAddressPage) {
        log.info(String.format("Set last name = %s from Cart Test",lastNameForAddressPage));
        driver.findElement(lastNameAddressPage).sendKeys(lastNameForAddressPage);
    }
    public void setAddress(String addressForAddressPage) {
        log.info(String.format("Set address = %s from Cart Test",addressForAddressPage));
        driver.findElement(address).sendKeys(addressForAddressPage);
    }
    public void setZipPostalCode(String zipPostalCodeForAddressPage) {
        log.info(String.format("Set zip postal code = %s from Cart Test",zipPostalCodeForAddressPage));
        driver.findElement(zipPostalCode).sendKeys(zipPostalCodeForAddressPage);
    }

    public void setCity(String cityForAddressPage) {
        log.info(String.format("Set city = %s from Cart Test",cityForAddressPage));
        driver.findElement(city).sendKeys(cityForAddressPage);
    }

    public void setHomePhone(String homePhoneForAddressPage) {
        log.info(String.format("Set home phone = %s from Cart Test",homePhoneForAddressPage));
        driver.findElement(homePhone).sendKeys(homePhoneForAddressPage);
    }

    public void chooseStateWithSelect(int index){
        log.info("Select state on address page by index");
        Select select=new Select(driver.findElement(stateSelect));
        List<WebElement>state=select.getOptions();
        select.selectByIndex(index);
    }

    public void setAddressTitle(String addressTitleForAddressPage) {
        log.info(String.format("Set address title = %s from Cart Test", addressTitleForAddressPage));
        driver.findElement(addressTitle).sendKeys(addressTitleForAddressPage);
    }
    public void clickSaveAddressButton(){
        log.info("Click 'Save Address' button");
        driver.findElement(saveAddressButton).click();
    }

    public boolean isAddressCompleteIconDisplayed() {
        AllureUtils.attachScreenshot(driver);
        return driver.findElement(addressCompleteIcon).isDisplayed();
    }

    public void clickToProceedToCheckoutButtonOnAddressesPage(){
        log.info("Click 'Proceed To Checkout' button on addresses page");
        driver.findElement(proceedToCheckoutOnAddressesPage).click();
    }

}
