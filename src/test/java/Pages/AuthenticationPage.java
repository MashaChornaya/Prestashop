package Pages;

import Utils.AllureUtils;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    private final static By loginButton=By.xpath("a[@class='login']") ;
    private final static By signInButton=By.cssSelector("#SubmitLogin");

    private final static String URL = "http://prestashop.qatestlab.com.ua/en/authentication?back=my-account";
    private final static By emailInputForNewAcc = By.cssSelector("#email_create");
    private final static By createAccountButton = By.cssSelector("#SubmitCreate");
    private final static By emailInputForSignIn=By.cssSelector("#email");
    private final static By passwordInputForSignIn=By.cssSelector("#passwd");

    @Override
    public void waitForPageLoaded() {
        log.info("Wait for login page loaded");
        waitForElementDisplayed(emailInputForNewAcc);
    }
    @Step("Logging in")
    public void authentication(String email, String password){
        log.info(String.format("Enter email= %s, and password= %s for sign in then press the 'sign in' button", email, password));
        setEmailForSignIn(email);
        setPasswordForSignIn(password);
        clickSignButton();
        AllureUtils.attachScreenshot(driver);
    }
    public void clickSignButton() {
        log.info("Click 'Sign In' button");
        driver.findElement(signInButton).click();
    }
    public void clickLogInButton() {
        log.info("Click 'Log In' button");
        driver.findElement(loginButton).click();
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

