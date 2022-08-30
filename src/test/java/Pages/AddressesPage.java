package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final static By state= By.xpath("//select[@id='id_state']/option[3]");
    private final static By addressTitle= By.xpath("//input[@id='alias']");
    private final static By saveAddressButton= By.xpath("//button[@id='submitAddress']");
    private final static By addressCompleteIcon= By.xpath("//h3[ text()='Your billing address']");


    @Override
    public void waitForPageLoaded() {
        log.info("Wait for create page loaded");
        waitForElementDisplayed(addressPageHeader);
    }
    public void setFirstNameAddressPage(String firstNameForAddressPage) {
        log.info("Set '{Masha}' from Cart Test");
        driver.findElement(firstNameAddressPage).sendKeys(firstNameForAddressPage);
    }
    public void setLastNameAddressPage(String lastNameForAddressPage) {
        log.info("Set '{Chornaya}' from Cart Test");
        driver.findElement(lastNameAddressPage).sendKeys(lastNameForAddressPage);
    }
    public void setAddress(String addressForAddressPage) {
        log.info("Set '{street New home 1 flat 1}' from Cart Test");
        driver.findElement(address).sendKeys(addressForAddressPage);
    }
    public void setZipPostalCode(String zipPostalCodeForAddressPage) {
        log.info("Set '{12365}' from Cart Test");
        driver.findElement(zipPostalCode).sendKeys(zipPostalCodeForAddressPage);
    }

    public void setCity(String cityForAddressPage) {
        log.info("Set '{New city}' from Cart Test");
        driver.findElement(city).sendKeys(cityForAddressPage);
    }

    public void setHomePhone(String homePhoneForAddressPage) {
        log.info("Set '{11234567890}' from Cart Test");
        driver.findElement(homePhone).sendKeys(homePhoneForAddressPage);
    }
    public void clickStateButton(){
        log.info("Choose your state");
        driver.findElement(state).click();
    }
    public void setAddressTitle(String addressTitleForAddressPage) {
        log.info("Set '{First address}' from Cart Test");
        driver.findElement(addressTitle).sendKeys(addressTitleForAddressPage);
    }
    public void clickSaveAddressButton(){
        log.info("Click 'Save Address' button");
        driver.findElement(saveAddressButton).click();
    }

    public boolean isAddressCompleteIconDisplayed() {

        return driver.findElement(addressCompleteIcon).isDisplayed();
    }

}
