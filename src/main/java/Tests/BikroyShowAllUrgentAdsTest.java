package Tests;

import Base.BaseTest;
import Pages.BikroyAllAdsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BikroyShowAllUrgentAdsTest {
    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = baseTest.initialization();
    BikroyAllAdsPage bikroyAllAdsPage = new BikroyAllAdsPage(webDriver);

    @BeforeClass
    void setUp(){
        webDriver.manage().window().maximize();
    }
    @org.testng.annotations.Test(priority = 1)
    void verifyAllUrgentAds(){

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        bikroyAllAdsPage.enterToClickUrgentAds();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        bikroyAllAdsPage.getCurrentUrl();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(bikroyAllAdsPage.getCurrentUrl(),"https://bikroy.com/en/ads/bangladesh?sort=date&order=desc&buy_now=0&urgent=1&page=1");

    }
    @AfterClass
    void tearDown(){
        webDriver.quit();
    }
}
