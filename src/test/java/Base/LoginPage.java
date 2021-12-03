package Base;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToWebsite() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);WebElement hoverLogInButton = driver.findElement(By.cssSelector("div.gekhq4-4.egoSnI"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverLogInButton).perform();
        TimeUnit.SECONDS.sleep(2);
        WebElement logInButton = driver.findElement(By.cssSelector("a[class='qjixn8-0 sc-1bydi5r-0 lghPw']"));
        logInButton.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement loginInputEmail = driver.findElement(By.id("L-UserNameField"));
        loginInputEmail.sendKeys("hsynakcn96@gmail.com");
        WebElement loginInputPassport = driver.findElement(By.xpath("//input[@id='L-PasswordField']"));
        loginInputPassport.sendKeys("12345_erq");
        WebElement SignInButton = driver.findElement(By.id("gg-login-enter"));
        SignInButton.click();
        TimeUnit.SECONDS.sleep(2);
        logger.info("Log in olundu.");
    }

    public void LoginCheck(){
        WebElement LoginImg = driver.findElement(By.xpath("//img[@class='sc-1o6eogh-0 i3yadh-0 ijSWbx']"));
        Assertions.assertTrue(LoginImg.isDisplayed());
        logger.info("Log in olunduğu kontrol edildi.");
    }
}
