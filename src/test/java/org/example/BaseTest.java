package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public abstract class BaseTest{

    protected WebDriver driver;
    protected WebDriverWait wait;
    public static Logger logger = Logger.getLogger(BaseTest.class.getName());

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/");
        logger.info("Tarayıcı açılıp https://www.gittigidiyor.com/ adresine gidildi.");
    }

    @After
    public void tearDown(){
        logger.info("Tarayıcı close ve quit ediliyor.");
        driver.close();
        driver.quit();
    }
}
