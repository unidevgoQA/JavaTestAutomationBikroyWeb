package Tests;

import Base.BaseTest;
import Pages.BikroyHomePage;
import Pages.BikroyLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BikroyLoginWithValidPasswordTest {

    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = baseTest.initialization();

    BikroyLoginPage bikroyLoginPage = new BikroyLoginPage(webDriver);
    BikroyHomePage bikroyHomePage = new BikroyHomePage(webDriver);

    @BeforeClass
    void setUp(){
        webDriver.manage().window().maximize();
    }

    @org.testng.annotations.Test(priority = 1)
    void verifyLoginWithValidCredentials(){

        bikroyHomePage.enterLoginButton();
        bikroyHomePage.getCurrentUrl();
        bikroyHomePage.enterContinueWithEmailButton();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        bikroyLoginPage.enterUsername("ashiq.qups@gmail.com");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        bikroyLoginPage.enterPassword("Asdfgh123456");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        bikroyLoginPage.enterLoginToDashboard();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(bikroyHomePage.getCurrentUrl(),"https://bikroy.com/?login-modal=true&redirect-url=/");
    }

    @AfterClass
    void tearDown(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.quit();
    }
}
