import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTest extends BaseTest {

    @Test
    public void checkDefferendValue() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.xpath("//input[@type='number']"));
        input.click();
        input.sendKeys("12345");
        Assert.assertEquals(input.getAttribute("value"), "12345");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "12346");
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "12345");
    }
}
