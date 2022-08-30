package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class HomePage  extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        log.info("Waiting for home page loaded");
        waitForElementDisplayed(home_Picture);
    }
    private final static String URL = "http://prestashop.qatestlab.com.ua/ru/";
    protected final By home_Picture= By.xpath("//img[@src='http://prestashop.qatestlab.com.ua/modules/homeslider/images/sample-1.jpg']");
    private final By signInButton = By.cssSelector(".login");
    private final By cartButton = By.xpath("//a[@title='View my shopping cart']");
    private final By searchInput = By.xpath("//input[@class='search_query form-control ac_input']");
    private final By womenSection = By.xpath("//a[@title='Women']");
    private final By dressesSection = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/descendant::a[@title='Dresses'][2]");
    private final By tShirtSection = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/descendant::a[@title='T-shirts'][2]");


    public void clickToSignInButton(){
        driver.findElement(signInButton).click();
    }
    public void clickToCartButton(){
        driver.findElement(cartButton).click();
    }

    public void clickToDressesSectionButton(){
        driver.findElement(dressesSection).click();
    }
    public void clickToWomenSectionButton(){
        driver.findElement(womenSection).click();
    }
    public void clickToTshirtButton(){
        driver.findElement(tShirtSection).click();
    }
}
