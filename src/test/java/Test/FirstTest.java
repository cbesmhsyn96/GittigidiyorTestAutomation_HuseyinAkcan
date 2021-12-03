package Test;

import Base.BasePage;
import Base.HomePage;
import Base.LoginPage;
import Base.SearchPage;
import org.example.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Expression;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class FirstTest extends BaseTest{

    @Test
    public void TestControl() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        BasePage basePage = new BasePage();
        homePage.PageControl();
        loginPage.loginToWebsite();
        loginPage.LoginCheck();
        searchPage.SearchMyWord();
        searchPage.fourProductChoose();
        searchPage.BackToHomePage();
        searchPage.SearchCanta();
        searchPage.addtoBasketTheProduct();
        searchPage.goToTheBasket();
        searchPage.ascProductCount();
        searchPage.goToPaymentPage();
        searchPage.editBasket();
    }
}
