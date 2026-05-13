import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuText extends BaseTest {

    @Test
    public void contextMenuText() {
        Actions actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(element).perform();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "You selected a context menu", "The text is not the same");
        alert.accept();
    }
}
