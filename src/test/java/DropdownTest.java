import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void checkDropdownMenu() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            assertTrue(option.isDisplayed());
        }
        dropdown.getFirstSelectedOption().click();
        assertEquals(dropdown.getFirstSelectedOption().getText(), "Please select an option");
        dropdown.selectByIndex(1);
        assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");
        dropdown.selectByIndex(2);
        assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
        softAssert.assertAll();
    }
}
