package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class DressesPage extends BasePage {
    public DressesPage(WebDriver driver) {
        super(driver);
    }

    private final static String URL = "http://prestashop.qatestlab.com.ua/ru/8-dresses";
    private final static By casualDresses = By.xpath("//div[@id='categories_block_left']/descendant::a[@href='http://prestashop.qatestlab.com.ua/ru/9-casual-dresses']");
    private final static By eveningDresses = By.xpath("//div[@id='categories_block_left']/descendant::a[@href='http://prestashop.qatestlab.com.ua/ru/10-evening-dresses']");
    private final static By summerDresses = By.xpath("//div[@id='categories_block_left']/descendant::a[@href='http://prestashop.qatestlab.com.ua/ru/11-summer-dresses']");
    private final static By dressPageIcon = By.cssSelector(".cat-name");
    private final By productLink = By.cssSelector("a[title$=Dress]");
    private final String productContainerLocator
            = "//div[@class='product-container']/div/div/a[@title='%s']";
private final static By item1=By.xpath("//a[@title='Printed Dress' and @class='product-name']");
    @Override
    public void waitForPageLoaded() {
        log.info("Wait for dress page loaded");
        waitForElementDisplayed(dressPageIcon);
    }

    public void clickCasualDressesButton() {
        log.info("Click 'Casual Dresses' button");
        driver.findElement(casualDresses).click();
    }

    public void clickEveningDressesButton() {
        log.info("Click 'Evening Dresses' button");
        driver.findElement(eveningDresses).click();
    }

    public void clickSummerDressesButton() {
        log.info("Click 'Summer Dresses' button");
        driver.findElement(summerDresses).click();
    }

    public void openItemByName(String productsName) {
        log.info("Open Item with product name from Base Test");
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(productLink).click();
    }

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(
                By.xpath(
                        String.format(productContainerLocator, productsName)
                )
        );

    }
    public void clickItem1Button() {
        log.info("Click 'Item1' button");
        driver.findElement(item1).click();
    }
}
