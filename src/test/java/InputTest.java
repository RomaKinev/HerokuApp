import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class InputTest extends BaseTest {

    @Test
    public void checkDefferendValue() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.xpath("//input[@type='number']"));
        input.click();
        input.sendKeys("12345");
        assertEquals(input.getAttribute("value"), "12345");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "12346");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "12345");
        softAssert.assertAll();
    }
}
