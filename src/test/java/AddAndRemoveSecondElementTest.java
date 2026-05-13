import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AddAndRemoveSecondElementTest extends BaseTest {

    @Test
    public void checkAddAndRemoveElements() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        int countDelete = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        assertEquals(countDelete, 2);
        driver.findElements(By.xpath("//button[text()='Delete']")).get(1).click();
        int countDeleteAfterClick = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        assertEquals(countDeleteAfterClick, 1);
        softAssert.assertAll();
    }
}
