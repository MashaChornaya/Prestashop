package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    private final static By casualDresses = By.xpath("//div[@id='categories_block_left']/descendant::li[1]");//("//div[@id='categories_block_left']/descendant::a[@href='http://prestashop.qatestlab.com.ua/ru/9-casual-dresses']");
    private final static By eveningDresses = By.xpath("//div[@id='categories_block_left']/descendant::li[2]");//("//div[@id='categories_block_left']/descendant::a[@href='http://prestashop.qatestlab.com.ua/ru/10-evening-dresses']");
    private final static By summerDresses = By.xpath("//div[@id='categories_block_left']/descendant::li[3]");//("//div[@id='categories_block_left']/descendant::a[@href='http://prestashop.qatestlab.com.ua/ru/11-summer-dresses']");
    private final static By dressPageIcon = By.cssSelector(".cat-name");
    private final static By resultsMessage = By.xpath("//span[@class='heading-counter']");
    private final static By productName= By.cssSelector("#center_column .product-name");
    private final static By productPrice = By.cssSelector("#center_column .right-block [itemprop='price']");
private final static By itemLink= By.xpath("//div[@class='right-block']//a[@class='product-name']");
    private final static By productLink =By.cssSelector("a[class$=_link]");
    private final String productContainerLocator
            = "//*[@class='product_img_link' and @title='%s']/ancestor::div[@class='product-container']";
    private final String productContainerPriceLocator
            = "//span[@class='price product-price' and contains(text(),'%s ')] /ancestor::div[@class='product-container']";

    private final static By warningAlert = By.xpath("//p[@class='alert alert-warning']");

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
        log.info(String.format("Open Item with product name = %s ",productsName));
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(itemLink).click();
    } 

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(
                By.xpath(
                        String.format(productContainerLocator, productsName)
                )
        );
    }
    public boolean getProductName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(productName).isDisplayed();
    }

    public boolean isResultsMassageDisplayed(){
        return driver.findElement(resultsMessage).isDisplayed();
    }
    public String getResultsMassageText() {
        log.info("Get text massage after searching product by name");
        return driver.findElement(resultsMessage).getText();
    }
    private WebElement getProductContainerByPrice(String productsPrice) {
        return driver.findElement(
                By.xpath(
                        String.format(productContainerPriceLocator, productsPrice)));
    }
    public boolean getProductPrice(String productsPrice) {
        WebElement productContainer = getProductContainerByPrice(productsPrice);
        return productContainer.findElement(productPrice).isDisplayed();
    }

    public boolean isWarningAlertDisplayed(){
        return driver.findElement(warningAlert).isDisplayed();
    }
    public String getWarningAlertText(){
        log.info("Get text from warning alert after searching product by name");
        return driver.findElement(warningAlert).getText();
    }
}
