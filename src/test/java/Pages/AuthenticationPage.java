package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    private final static By signInButton=By.cssSelector("#SubmitLogin");

    private final static String URL = "http://prestashop.qatestlab.com.ua/en/authentication?back=my-account";
    private final static By emailInputForNewAcc = By.cssSelector("#email_create");
    private final static By createAccountButton = By.xpath("//i[@class='icon-user left']");
    private final static By emailInputForSignIn=By.cssSelector("#email");
    private final static By passwordInputForSignIn=By.cssSelector("#passwd");


    @Override
    public void waitForPageLoaded() {
        log.info("Wait for login page loaded");
        waitForElementDisplayed(emailInputForNewAcc);
    }
    public void authentication(String email, String password){
        setEmailForSignIn(email);
        setPasswordForSignIn(password);
    }
    public void clickSignButton() {
        log.info("Click 'Sign In' button");
        driver.findElement(signInButton).click();
    }
    public void setEmail(String email) {
        log.info(String.format("Set email = %s", email));
        driver.findElement(emailInputForNewAcc).sendKeys(email);
    }
    public void clickCreateAccountButton() {
        log.info("Click 'Create Account' button");
        driver.findElement(createAccountButton).click();
    }
    public void setEmailForSignIn(String emailForSignIn) {
        log.info(String.format("Set email = %s", emailForSignIn));
        driver.findElement(emailInputForSignIn).sendKeys(emailForSignIn);
    }
    public void setPasswordForSignIn(String passwordForSignIn) {
        log.info(String.format("Set password = %s", passwordForSignIn));
        driver.findElement(passwordInputForSignIn).sendKeys(passwordForSignIn);
    }

}

