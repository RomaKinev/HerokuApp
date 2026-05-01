import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddAndRemoveSecondElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAddAndRemoveElements(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        int countDelete = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(countDelete,2);
        driver.findElements(By.xpath("//button[text()='Delete']")).get(1).click();
        int countDeleteAfterClick = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(countDeleteAfterClick,1);
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
