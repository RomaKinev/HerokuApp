import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClickCheckboxTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkCheckboxIsChecked(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']")).get(0);
        WebElement checkbox2 = driver.findElements(By.xpath("//input[@type='checkbox']")).get(1);
        int countCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assert.assertEquals(countCheckbox,2);
        Assert.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
