package Base;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void PageControl(){
        WebElement pageLogo = driver.findElement(By.cssSelector(".sc-1fjiks5-1.dCMDfb"));
        Assert.assertTrue(pageLogo.isDisplayed());
        logger.info("gittigidiyor.com sayfasının açıldığı kontrol edildi.");
    }
}
