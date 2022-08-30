package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ItemDetailPage extends BasePage {
    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }
    private final static By itemName= By.xpath("//h1[@itemprop='name']");
    private final static By itemPicture=By.xpath("//img[@id='bigpic']");
    private final static By itemPrice= By.xpath("//span[@itemprop='price']");
    private final static By itemShortDescription= By.xpath("//div[@id='short_description_content']");
    private final static By addToCartButton= By.xpath("//p[@id='add_to_cart']");
    private final static By addToCartItemIcon = By.xpath("//h2[text()][1]");
    private final static By clickCheckOutButton = By.xpath("//a[@class='btn btn-default button button-medium']");
    private final static By clickContinueShoppingButton = By.xpath("//span[@title='Продолжить покупки']");
    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for item details page loaded");
        waitForElementDisplayed(itemPicture);
    }
    public String getItemName() {
        log.info("Get item name");
        return driver.findElement(itemName).getText();
    }
    public String getItemShortDescription(){
        log.info("Get item description");
        return driver.findElement(itemShortDescription).getText();
    }
    public String getItemPrice() {
        log.info("Get item price");
        return driver.findElement(itemPrice).getText();

    }
    public void clickAddToCardButton() {
        log.info("Click to cart button");
        driver.findElement(addToCartButton).click();
    }

    public boolean isAddToCartItemIconDisplayed() {
        return driver.findElement(addToCartItemIcon).isDisplayed();
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
        log.info("Click Continue Shopping button");
        driver.findElement(clickContinueShoppingButton).click();
    }

}
