import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.*;

public class DynamicControls extends BaseTest{

    @Test
    public void checkDynamicControls(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        assertFalse(driver.findElement(By.xpath("//input")).isEnabled(),"Input is enabled");
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(driver.findElement(By.xpath("//input")).isEnabled(),"Input is Disabled");

// Примеры оставил для себя

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        int numberOfElements = driver.findElements(By.cssSelector("[type='checkbox']")).size();
//        assertEquals(numberOfElements,0);

      //  driver.switchTo().frame("mce_0_ifr");
      //  driver.switchTo().defaultContent();

//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("sdf");
//        alert.accept();
//        alert.dismiss();
//        alert.getText();

//        File file = new File("src/test/java/1.html");
//        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());

//        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
//        Actions actions = new Actions(driver);
//        actions.click(checkbox).perform();
//        actions.clickAndHold(checkbox).perform();
//        actions.contextClick(checkbox).perform(); //клик правой кнопкой мыши
//        actions.doubleClick(checkbox).perform();
//        actions.dragAndDrop(checkbox,checkbox).perform();
//        actions.dragAndDropBy(checkbox,100,120).perform();
//        actions.keyDown(Keys.CONTROL).perform();
//        actions.keyUp(Keys.CONTROL).perform();
//        actions.moveToElement(checkbox).perform();//навести на элемент
//        actions.pause(500);
    }
}
