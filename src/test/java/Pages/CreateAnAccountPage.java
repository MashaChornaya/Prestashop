package Pages;

import Utils.AllureUtils;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    private final static By passwordInput = By.cssSelector("#passwd");
    private final static By submitAccountButton = By.cssSelector("#submitAccount");
    private final static By accountIcon = By.xpath("//h1[@class='page-heading']");
    private final static By errorMassage=By.xpath("//div[@class='alert alert-danger']/descendant::li[text()=' is required.']");

    private final static By dayOfBirthSelect = By.xpath("//select[@id='days']");
    private final static By monthsOfBirthSelect = By.xpath("//select[@id='months']");

    private final static By yearOfBirthInput = By.xpath("//div[@id='cuselFrame-years']");


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
        log.info(String.format("Set firstName = %s", firstName));
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        log.info(String.format("Set lastName = %s", lastName));
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void setPassword(String password) {
        log.info(String.format("Set password = %s", password));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickToDayOfBirthSelect(int index){
        log.info("Select day of birth  by index");
        Select select=new Select(driver.findElement(dayOfBirthSelect));
        List<WebElement> day=select.getOptions();
        select.selectByIndex(index);
    }
    public void clickToMonthsOfBirthSelect(int index){
        log.info("Select months of birth  by index");
        Select select=new Select(driver.findElement(monthsOfBirthSelect));
        List<WebElement> day=select.getOptions();
        select.selectByIndex(index);
    }

    public void setYearOfBirthInput(String yearOfBirth){
        log.info(String.format("Set year = %s", yearOfBirthInput));
        driver.findElement(yearOfBirthInput).sendKeys(yearOfBirth);
    }


    public void clickSubmitAccount() {
        log.info("Click to 'Submit account' button");
        driver.findElement(submitAccountButton).click();
    }
    public boolean isAccountIconDisplayed() {
        return driver.findElement(accountIcon).isDisplayed();
    }
    public String getAccountIconText() {
        return driver.findElement(accountIcon).getText();
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

