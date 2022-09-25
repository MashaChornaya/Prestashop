package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class ItemDetailPage extends BasePage {
    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }
    private final static By itemName= By.cssSelector("[itemprop='name']");
    private final static By itemNameQuick=By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']//h1");
    private final static By itemPicture=By.cssSelector("[id='bigpic']");
    private final static By itemPrice=By.xpath("//span[@id='our_price_display']") ;
    private final static By itemPriceQuick = By.cssSelector("#our_price_display");
    private final static By itemShortDescription= By.cssSelector("#short_description_content");
    private final static By itemShortDescriptionQuick= By.xpath("//div[@id='short_description_content']//p");
    private final static By addToCartButton= By.cssSelector("#add_to_cart");
    private final static By addToCartItemIcon = By.xpath("//h2[text()][1]");
    private final static By clickCheckOutButton = By.xpath("//a[@class='btn btn-default button button-medium']");
    private final static By clickContinueShoppingButton = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
   private final static By clickCloseWindowButton = By.cssSelector(".cross");
   private final static By cartButtonItemDetailsPage = By.cssSelector(".shopping_cart a");
    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for item details page loaded");
        waitForElementDisplayed(itemPicture);
    }
    public String getItemName() {
        log.info("Get item name");
        return driver.findElement(itemName).getText();
    }
    public String getItemNameQuick() {
        log.info("Get item name on quick page");
        return driver.findElement(itemNameQuick).getText();
    }
    public String getItemShortDescription(){
        log.info("Get item description");
        return driver.findElement(itemShortDescription).getText();
    }
    public String getItemShortDescriptionQuick(){
        log.info("Get item description on quick page");
        return driver.findElement(itemShortDescriptionQuick).getText();
    }
    public String getItemPrice() {
        log.info("Get item price");
        return driver.findElement(itemPrice).getText();

    }
    public String getItemPriceQuick() {
        log.info("Get item price on quick page");
        return driver.findElement(itemPriceQuick).getText();
    }
    public void clickAddToCardButton() {
        log.info("Click to cart button");
        driver.findElement(addToCartButton).click();
    }

    public boolean isAddToCartItemIconDisplayed() {
        return driver.findElement(addToCartItemIcon).isDisplayed();
    }

    public void waitForAddToCartItemIconDisplayed() {
        WebElement addToCartItemIElement=(new WebDriverWait(driver,5))
                .until(ExpectedConditions.elementToBeClickable(addToCartItemIcon));
    }
    public String getAddToCartItemIconText() {
        log.info("Get text after adding item to cart button");
        return driver.findElement(addToCartItemIcon).getText();
    }
    public void clickCheckOutButton() {
        log.info("Click CheckOut button");
        driver.findElement(clickCheckOutButton).click();
    }
    public void clickContinueShoppingButton() {
        log.info("Click 'Continue Shopping' button");
        driver.findElement(clickContinueShoppingButton).click();
    }
public void clickCloseWindowButton(){
    log.info("Click 'Close window' button");
    driver.findElement(clickCloseWindowButton).click();
}
public void clickCartButtonItemDetailsButton(){
        log.info("Click 'Shopping cart' button");
        driver.findElement(cartButtonItemDetailsPage).click();
}
}
