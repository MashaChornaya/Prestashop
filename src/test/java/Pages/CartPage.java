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
    private final static By cartPageHeader = By.cssSelector("#cart_title");
    private final static By trashButton=By.cssSelector(".cart_quantity_delete");
    private final static By proceedToCheckoutButton=By.xpath("//span[text()='Proceed to checkout']");
    private final static By valueOfCart =By.cssSelector(".heading-counter");
    private final static By cartButton=By.cssSelector(".shopping_cart");

    @Override
    public void waitForPageLoaded() {
        log.info("Wait for cart page loaded");
        waitForElementDisplayed(cartPageHeader);
    }

    public void clickProceedToCheckoutButton() {
        log.info("Click 'Proceed To Checkout' button");
        driver.findElement(proceedToCheckoutButton).click();
    }
        public void clickTrashButton() {
        log.info("Click 'Trash' button");
        driver.findElement(trashButton).click();
    }
    public void clickCartButton(){
        log.info("Click 'Cart' button");
        driver.findElement(cartButton).click();
    }
    public void waitForCartValueTextIsDisplayed() {
        WebElement cartValueText=(new WebDriverWait(driver,5))
                .until(ExpectedConditions.presenceOfElementLocated(valueOfCart));
    }
    public String getCartValue(){
        return driver.findElement(valueOfCart).getText();
    }


    public boolean isAlertDisplayed() {
        return driver.findElement(valueOfCart).isDisplayed();
    }
}
