package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

@Log4j2
public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    private final static By myAddresses = By.xpath("//a[@title='Addresses']");
    private final static By deleteAddressesButton = By.xpath("//a[@title='Delete']");
    @Override
    public void waitForPageLoaded() {

    }

    public void clickToMyAddressesButton(){
        log.info("Click 'My Addresses' button");
        driver.findElement(myAddresses).click();
    }
    public void clickToDeleteAddressesButton(){
        log.info("Click 'Delete' button");
        driver.findElement(deleteAddressesButton).click();
    }


    public void clickToAlert()  {
        Alert firstAlert = driver.switchTo().alert();
        String alertText = firstAlert.getText();
        Assert.assertFalse(alertText.isEmpty());
        firstAlert.accept();
        driver.switchTo().defaultContent();
    }
}
