import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class ClickCheckboxTest extends BaseTest {

    @Test
    public void checkCheckboxIsChecked() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']")).get(0);
        WebElement checkbox2 = driver.findElements(By.xpath("//input[@type='checkbox']")).get(1);
        int countCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        assertEquals(countCheckbox, 2);
        assertFalse(checkbox1.isSelected());
        checkbox1.click();
        assertTrue(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());
        checkbox2.click();
        assertFalse(checkbox2.isSelected());
        softAssert.assertAll();
    }
}
