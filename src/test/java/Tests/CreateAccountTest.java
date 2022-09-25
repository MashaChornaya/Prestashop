package Tests;

import Pages.AuthenticationPage;
import Pages.CreateAnAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    AuthenticationPage authenticationPage;
    CreateAnAccountPage createAnAccountPage;

    @BeforeClass(alwaysRun = true)
    public void initialise(){
        authenticationPage=new AuthenticationPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
    }
    @Test(groups = {"Smoke"})
    @Description("Positive New Account Authorisation Test")
    @Severity(SeverityLevel.CRITICAL)
    @Link("http://prestashop.qatestlab.com.ua/")
    public void positiveCreateAccountTest() {
        Assert.assertTrue(createAnAccountPage.isAccountIconDisplayed());
        Assert.assertEquals(createAnAccountPage.getAccountIconText(),"MY ACCOUNT");
    }

}