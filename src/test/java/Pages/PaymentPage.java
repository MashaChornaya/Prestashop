package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private final static By warningOnPaymentPage = By.xpath("//p[@class='alert alert-warning']");
    private final static By paymentPageHeader =By.cssSelector(".page-heading");

    @Override
    public void waitForPageLoaded() {
        log.info("Wait for shipping page loaded");
        waitForElementDisplayed(paymentPageHeader);
    }
    public String getWarningOnPaymentPageText() {
        log.info("Get text from warning on payment page");
        return driver.findElement(warningOnPaymentPage).getText();
    }
}
