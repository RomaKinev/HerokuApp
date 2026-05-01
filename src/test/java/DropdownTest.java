import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkDropdownMenu(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option: options){
            Assert.assertTrue(option.isDisplayed());
        }
        dropdown.getFirstSelectedOption().click();
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Please select an option");
        dropdown.selectByIndex(1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");
        dropdown.selectByIndex(2);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
