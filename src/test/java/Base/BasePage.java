package Base;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends BaseTest {
    protected WebDriverWait wait;
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public BasePage() {
    }
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickWebElement(WebElement element){
        element.click();
    }
    public List<WebElement> findAll(By by){
        return driver.findElements(by);
    }
}
