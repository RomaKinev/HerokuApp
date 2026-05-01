import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkDefferendValue(){
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.xpath("//input[@type='number']"));
        input.click();
        input.sendKeys("12345");
        Assert.assertEquals(input.getAttribute("value"),"12345");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"),"12346");
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"),"12345");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
