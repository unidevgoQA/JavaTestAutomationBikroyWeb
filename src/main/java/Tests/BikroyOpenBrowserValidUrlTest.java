package Tests;

import Base.BaseTest;
import Pages.BikroyHomePage;
import Pages.BikroyLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BikroyOpenBrowserValidUrlTest {
    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = baseTest.initialization();

    BikroyLoginPage bikroyLoginPage;
    BikroyHomePage bikroyHomePage = new BikroyHomePage(webDriver);;

    @BeforeClass
    void setUp(){
        webDriver.get("https://bikroy.com/");
        webDriver.manage().window().maximize();

    }

    @org.testng.annotations.Test(priority = 1)
    public void verifyPageTitle(){

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(bikroyHomePage.getHomePageTitle(),"Bikroy.com - Electronics, Cars, Property and Jobs in Bangladesh");
    }

    @AfterClass
    void tearDown(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.quit();
    }


}
