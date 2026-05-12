import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationsTest extends BaseTest {

    @Test
    public void checkNitificationText() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[text()='Click here']")).click();
        WebElement notifiMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = notifiMessage.getText();
        String expectedMessage = "Action successful";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
