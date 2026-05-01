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

public class NotificationsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkNitificationText(){
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[text()='Click here']")).click();
        WebElement notifiMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = notifiMessage.getText();
        String expectedMessage = "Action successful";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
