import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void swapInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        driver.switchTo().frame("mce_0_ifr");
        assertEquals(driver.findElement(By.xpath("//body[@data-id]")).getText(),
                "Your content goes here.",
                "The text is not the same");
    }
}
