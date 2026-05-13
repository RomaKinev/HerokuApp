import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class DataTableTest extends BaseTest {

    @Test
    public void checkTableValue() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/tables");
        assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[2]")).getText(), "Frank");
        assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[3]")).getText(), "fbach@yahoo.com");
        assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[4]")).getText(), "$51.00");
        assertEquals(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[4]/td[5]")).getText(), "http://www.timconway.com");
        softAssert.assertAll();
    }
}
