import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/java/1.html");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "1.html", "The text is not the same");
    }
}
