import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTableTest extends BaseTest {

    @Test
    public void checkTableValue() {
        driver.get("http://the-internet.herokuapp.com/tables");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[2]")).getText(), "Frank");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[3]")).getText(), "fbach@yahoo.com");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[2]/td[4]")).getText(), "$51.00");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[4]/td[5]")).getText(), "http://www.timconway.com");
    }
}
