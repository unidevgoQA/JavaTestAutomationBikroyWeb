package Tests;

import Base.BaseTest;
import Pages.BikroyHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BikroyShowAllAdsTest {

    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = baseTest.initialization();

    BikroyHomePage bikroyHomePage = new BikroyHomePage(webDriver);

    @BeforeClass
    void setUp(){
        webDriver.get("https://bikroy.com/");
        webDriver.manage().window().maximize();
    }
    @org.testng.annotations.Test(priority = 1)
    void verifyAllAds(){
        bikroyHomePage.enterAllAdsButton();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(bikroyHomePage.getCurrentUrl(),"https://bikroy.com/en/ads");
    }
    @AfterClass
    void tearDown(){
        webDriver.quit();
    }
}
