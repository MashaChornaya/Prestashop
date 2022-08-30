package Tests;

import Pages.AuthenticationPage;
import Pages.CreateAnAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {
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
    @Link("http://prestashop.qatestlab.com")
    public void positiveAuthorisationTest() {
        authenticationPage.setEmail(EMAIL);
        authenticationPage.clickCreateAccountButton();
        createAnAccountPage.clickTitleButton();
        createAnAccountPage.setFirstName(FIRST_NAME);
        createAnAccountPage.setLastName(LAST_NAME);
        createAnAccountPage.setPassword(PASSWORD);
        //createAnAccountPage.clickToDayOfBirthSelect();
        createAnAccountPage.clickSubmitAccount();
        Assert.assertTrue(createAnAccountPage.isNewAccountIconDisplayed());
        Assert.assertEquals(createAnAccountPage.getNewAccountIconText(),"My account");
    }
    @Test(groups = {"Smoke"})
    @Description("Positive Sign In Test")
    @Severity(SeverityLevel.CRITICAL)
    @Link("http://prestashop.qatestlab.com")
    public void positiveSignInTest() {
        authenticationPage.setEmailForSignIn(EMAIL);
        authenticationPage.setPasswordForSignIn(PASSWORD);
        authenticationPage.clickSignButton();
        Assert.assertTrue(createAnAccountPage.isNewAccountIconDisplayed());
        Assert.assertEquals(createAnAccountPage.getNewAccountIconText(),"My account");
    }
    @Test(dataProvider = "negativeAuthentication", groups = {"Negative", "Regression"})
    @Description("Troubles with first name, last name and password")
    @Severity(SeverityLevel.CRITICAL)
    @Link("http://prestashop.qatestlab.com")
    public void negativeAuthorisationTest(String firstName,String lastName, String password, String errorMessage) {
        createAnAccountPage.setFirstName(firstName);
        createAnAccountPage.setLastName(lastName);
        createAnAccountPage.setPassword(password);
        createAnAccountPage.clickSubmitAccount();
        Assert.assertTrue(createAnAccountPage.isErrorMessageDisplayed());
        Assert.assertEquals(createAnAccountPage.getErrorMessageText(), errorMessage);
    }
    @DataProvider(name = "negativeAuthentication")
    public Object[][] negativeAuthorisationTestData() {
        return new Object[][]{
                {FIRST_NAME,LAST_NAME, "", "passwd is required."},
                {FIRST_NAME,"",PASSWORD, "lastname is required."},
                {"",LAST_NAME,PASSWORD, "firstname is required."},
        };
    }
}
