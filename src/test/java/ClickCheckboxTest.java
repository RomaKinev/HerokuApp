import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickCheckboxTest extends BaseTest {

    @Test
    public void checkCheckboxIsChecked() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']")).get(0);
        WebElement checkbox2 = driver.findElements(By.xpath("//input[@type='checkbox']")).get(1);
        int countCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assert.assertEquals(countCheckbox, 2);
        Assert.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
    }
}
