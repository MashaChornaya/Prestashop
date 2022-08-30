package Pages;

import Utils.AllureUtils;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class CreateAnAccountPage extends BasePage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    private final static String URL = "http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation";
    private final static By accountCreateIcon = By.xpath("//h1[@class='page-heading' and text()]");
    private final static By titleButton = By.cssSelector("#id_gender2");
    private final static By firstNameInput = By.cssSelector("#customer_firstname");
    private final static By lastNameInput = By.cssSelector("#customer_lastname");
    private final static By dayOfBirthSelect = By.cssSelector("#days");
    private final static By passwordInput = By.cssSelector("#passwd");
    private final static By submitAccountButton = By.cssSelector("#submitAccount");
    private final static By newAccountIcon = By.xpath("//h1[@class='page-heading']");
    private final static By errorMassage=By.xpath("//div[@class='alert alert-danger']/descendant::li[text()=' is required.']");


    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for create page loaded");
        waitForElementDisplayed(accountCreateIcon);
    }

    public void clickTitleButton() {
        log.info("Clicking 'Title' button");
        driver.findElement(titleButton).click();
    }
    public void setFirstName(String firstName) {
        log.info(String.format("Setting firstName = %s", firstName));
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        log.info(String.format("Setting lastName = %s", lastName));
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void setPassword(String password) {
        log.info(String.format("Setting password = %s", password));
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickToDayOfBirthSelect() {
        log.info("Clicking to 'DayOfBirth' select");
        driver.findElement(dayOfBirthSelect).click();
    }
    public void selectDayOfBirth(String option){
        WebElement dayOfBirth= driver.findElement(dayOfBirthSelect);
        Select select=new Select(dayOfBirth);
       select.selectByVisibleText(option);
    }
    public void clickSubmitAccount() {
        log.info("Click to 'Submit account' button");
        driver.findElement(submitAccountButton).click();
    }
    public boolean isNewAccountIconDisplayed() {
        return driver.findElement(newAccountIcon).isDisplayed();
    }
    public String getNewAccountIconText() {
        return driver.findElement(newAccountIcon).getText();
    }


    @Step("Logging in")
    @Attachment(value = "screenshot", type = "image/png")
    public void login(String firstName, String password, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        clickSubmitAccount();
        AllureUtils.attachScreenshot(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMassage).isDisplayed();
    }
    public String getErrorMessageText() {

        return driver.findElement(errorMassage).getText();
    }
}

