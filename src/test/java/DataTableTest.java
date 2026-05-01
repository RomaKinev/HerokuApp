import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataTableTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkTableValue(){
        driver.get("http://the-internet.herokuapp.com/tables");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[2]")).getText(), "Frank");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[3]")).getText(), "fbach@yahoo.com");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[4]")).getText(), "$51.00");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[4]/td[5]")).getText(), "http://www.timconway.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
