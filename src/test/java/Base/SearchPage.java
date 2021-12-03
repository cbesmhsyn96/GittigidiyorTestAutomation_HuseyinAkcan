package Base;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.beans.Expression;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
    public class SearchPage extends BasePage {
        Actions action = new Actions(driver);
        Random r = new Random();

        public SearchPage(WebDriver driver) {
            super(driver);
        }

        public void SearchMyWord() throws InterruptedException {
            WebElement seachBoxItem = driver.findElement(By.cssSelector("input[data-cy='header-search-input']"));
            TimeUnit.SECONDS.sleep(2);
            seachBoxItem.sendKeys("atkı");
            TimeUnit.SECONDS.sleep(1);
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
            searchButton.click();
            Thread.sleep(2000);
            logger.info("atkı ürünü arandı.");
        }
        public void fourProductChoose()throws InterruptedException{
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Actions actions = new Actions(driver);

            for (int i = 0; i < 4; i++) {
                int result = 1 + r.nextInt(31);
                System.out.println(result);
                By productsItem = By.xpath("(//div[@data-cy=\"product-favorite\"])[" + result + "]");
                System.out.println(productsItem);
                //findElement(productsItem).click();
                Thread.sleep(1000);
                actions.moveToElement(driver.findElement(productsItem)).click().build().perform();
                Thread.sleep(1000);
            }
            logger.info("Rastgele 4 ürün favorilere eklendi.");
        }

        public void BackToHomePage() {
            WebElement HomeButton = driver.findElement(By.xpath("//div[@class='sc-1o6eogh-1 drryHP'][1]"));
            clickWebElement(HomeButton);
            logger.info("Ana sayfaya dönüldü.");
        }

        public void SearchCanta(){
            WebElement canta = driver.findElement(By.cssSelector("input[data-cy='header-search-input']"));
            canta.sendKeys("çanta");
            WebElement cantaButton = driver.findElement(By.cssSelector("button[data-cy='search-find-button']"));
            cantaButton.click();
        }
        public void addtoBasketTheProduct()throws InterruptedException {
            List<WebElement> urunler = driver.findElements(By.cssSelector("li[class='sc-1nx8ums-0 dyekHG']"));
            if (driver.findElement(By.cssSelector("section[class='tyj39b-4 gAqqOR']")).isDisplayed()) {
                driver.findElement(By.cssSelector("section[class='tyj39b-4 gAqqOR']")).click();
                TimeUnit.SECONDS.sleep(2);
            }

            action.moveToElement(urunler.get(6)).perform();
            TimeUnit.SECONDS.sleep(2);
            List<WebElement> urunlerBtn = driver.findElements(By.cssSelector("footer>button[class='qjixn8-0 sc-1bydi5r-0 dGNqQc pXiHf sc-1n49x8z-3 bhXnM']"));
            urunlerBtn.get(6).click();
        }
        public void goToTheBasket()throws InterruptedException {
            WebElement sepetHover = driver.findElement(By.linkText("Sepetim"));
            action.moveToElement(sepetHover).perform();
            TimeUnit.SECONDS.sleep(2);
            WebElement sepeteGit = driver.findElement(By.cssSelector("div[class='sc-1nx8ums-0 iqjFHT']>a"));
            sepeteGit.click();
        }
        public void ascProductCount()throws InterruptedException {
            Select drpMount = new Select(driver.findElement(By.cssSelector("div[class='gg-input gg-input-select ']>select[class='amount']")));
            drpMount.selectByValue("2");
        }
        public void goToPaymentPage()throws InterruptedException {
            WebElement paymentButton = driver.findElement(By.cssSelector("div[id='cart-continue-button-container']>input"));
            paymentButton.click();
            TimeUnit.SECONDS.sleep(3);
            WebElement saveButton = driver.findElement(By.cssSelector("button[value='Kaydet']"));
            saveButton.click();
            TimeUnit.SECONDS.sleep(3);
            List<WebElement> errorList = driver.findElements(By.cssSelector("div[class='gg-input-error-text gg-d-24']>p"));
            for (WebElement errorString : errorList) {
                Assert.assertNotNull(errorString);
                System.out.println("Hata mesajı :" + errorString.getText());
            }
            //Hata mesajlaraını konsolda görüyorum.
        }
        public void editBasket()throws InterruptedException{
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,800)");
            TimeUnit.SECONDS.sleep(3);
            WebElement sepetiDüzenle = driver.findElement(By.linkText("Sepeti Düzenle"));
            sepetiDüzenle.click();
            jse.executeScript("window.scrollBy(0,300)");
            TimeUnit.SECONDS.sleep(3);
        }
    }