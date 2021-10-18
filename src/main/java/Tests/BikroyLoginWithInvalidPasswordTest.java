package Tests;

import Base.BaseTest;
import Pages.BikroyHomePage;
import Pages.BikroyLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BikroyLoginWithInvalidPasswordTest {

    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = baseTest.initialization();

    BikroyLoginPage bikroyLoginPage = new BikroyLoginPage(webDriver);
    BikroyHomePage bikroyHomePage = new BikroyHomePage(webDriver);

    @BeforeClass
    void setUp(){
        webDriver.manage().window().maximize();
    }

    @org.testng.annotations.Test(priority = 1)
    void verifyLoginWithInvalidCredentials(){

        bikroyHomePage.enterLoginButton();
        bikroyHomePage.getCurrentUrl();
        bikroyHomePage.enterContinueWithEmailButton();

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        bikroyLoginPage.enterUsername("ashiq.qups@gmail.com");
        bikroyLoginPage.enterPassword("Asdfgh12345");
        bikroyLoginPage.enterLoginToDashboard();

        Assert.assertEquals(bikroyLoginPage.getErrorMessage(),"The email or password you entered did not match our records. Please double-check and try again.");
    }

    @AfterClass
    void tearDown(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.quit();
    }
}
