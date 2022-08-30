package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    final static String EMAIL="mashabigdreams@gmail.com";
    final static String PASSWORD="qwerty123456";
    final static String FIRST_NAME="Masha";
    final static String LAST_NAME="Chornaya";

    final static String PRODUCT_NAME="Printed Dress";
    protected WebDriver driver;
    protected AuthenticationPage authenticationPage;
    protected CreateAnAccountPage createAnAccountPage;
    protected CartPage cartPage;
    protected HomePage homePage;


    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true, description = "initialise driver")
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        log.debug("Browser started");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
        authenticationPage=new AuthenticationPage(driver);
        testContext.setAttribute("driver", driver);
    }

    @BeforeMethod(description = "navigate")
    public void navigate(){
        log.debug("Page opened");
        driver.get("http://prestashop.qatestlab.com.ua/en/");
    }
    @AfterMethod(alwaysRun = true, description = "close browser")
    public void clearCookies() {
        log.debug("Clear all cookies here");
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
    @AfterClass
    public void tearDown() {
        log.debug("Driver closed");
        driver.quit();

    }
}
