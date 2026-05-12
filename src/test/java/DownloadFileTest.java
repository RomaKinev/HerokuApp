import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DownloadFileTest extends BaseTest {

    @Test
    public void testDownloadFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement link = driver.findElement(By.xpath("//a[@href='download/test_upload.txt']"));
        link.click();

        String fileNameFromPage = link.getText();
        String filePath = "/Users/romankinev/Downloads/";
        Path downloadedFile = Paths.get(filePath + fileNameFromPage);

        for (int i = 0; i < 20; i++) {
            if (Files.exists(downloadedFile)) break;
            Thread.sleep(500);
        }
        assertTrue(Files.exists(downloadedFile), "Файл не скачался");
        String downloadedFileName = downloadedFile.getFileName().toString();
        assertEquals(downloadedFileName, fileNameFromPage,
                "Имя скачанного файла не совпадает");
    }
}
