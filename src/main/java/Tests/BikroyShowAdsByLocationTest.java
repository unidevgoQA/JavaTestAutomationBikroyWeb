package Tests;

import Base.BaseTest;
import Pages.BikroyAllAdsPage;
import Pages.BikroyHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BikroyShowAdsByLocationTest {
    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = new ChromeDriver();

    BikroyAllAdsPage bikroyAllAdsPage = new BikroyAllAdsPage(webDriver);

    @BeforeClass
    void setUp(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

    }
    @Test(priority = 1)
    public void verifyShowAdsByLocation(){
        bikroyAllAdsPage.enterToClickShowLocationAds();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        bikroyAllAdsPage.getCurrentUrl();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(bikroyAllAdsPage.getCurrentUrl(),"https://bikroy.com/en/ads/dhaka-division");
    }
    @AfterClass
    void tearDown(){

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.quit();
    }
}
