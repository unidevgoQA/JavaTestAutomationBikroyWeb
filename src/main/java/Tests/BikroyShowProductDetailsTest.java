package Tests;

import Base.BaseTest;
import Pages.BikroyHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BikroyShowProductDetailsTest {

    BaseTest baseTest = new BaseTest();
    WebDriver webDriver = baseTest.initialization();
    BikroyHomePage bikroyHomePage = new BikroyHomePage(webDriver);

    @BeforeClass
    void setUp(){
        webDriver.manage().window().maximize();
    }

    @org.testng.annotations.Test(priority = 1)
    void verifyShowProductDetails(){

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        bikroyHomePage.typeOnSearch("Dell Laptop");

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        bikroyHomePage.enterToSearch();

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(bikroyHomePage.getCurrentUrl(),"https://bikroy.com/en/ads?query=Dell%20Laptop");

        bikroyHomePage.enterToClickProductDetails();
        Assert.assertNotSame("https://bikroy.com/en/ads?query=Dell%20Laptop",bikroyHomePage.getCurrentUrl());

    }
    @AfterClass
    void tearDown(){
        webDriver.quit();
    }
}
