package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final static String URL = "http://prestashop.qatestlab.com.ua/ru/order";
    private final static By cartPageHeader = By.xpath("//h1[@id='cart_title']/text()");
    private final static By itemName=By.xpath("//p[@class='product-name']/a[@href and text()='Blouse']");
    private final static By itemPrice=By.xpath("//span[@id='product_price_3_13_0']");
    private final static By trashButton=By.cssSelector(".icon-trash");
    private final static By proceedToCheckoutButton=By.xpath("//span[text()='Proceed to checkout']");
    private final static By valueOfCart = By.xpath("//span[@id='summary_products_quantity']");


    @Override
    public void waitForPageLoaded() {
        log.info("Wait for create page loaded");
        waitForElementDisplayed(cartPageHeader);
    }
    public String getChosenItemName() {
        log.info("Item name check");
        return driver.findElement(itemName).getText();
    }
    public String getChosenItemPrice() {
        log.info("Item price check");
        return driver.findElement(itemPrice).getText();
    }
    public void clickProceedToCheckoutButton() {
        log.info("Click 'Proceed To Checkout' button");
        driver.findElement(proceedToCheckoutButton).click();
    }
        public void clickTrashButton() {
        log.info("Click 'Trash' button");
        driver.findElement(trashButton).click();
    }
    public void waitForCartValueTextIsDisplayed() {
        WebElement cartValueText=(new WebDriverWait(driver,5))
                .until(ExpectedConditions.presenceOfElementLocated(valueOfCart));
    }
    public String getCartValue(){
        return driver.findElement(valueOfCart).getText();
    }

}
