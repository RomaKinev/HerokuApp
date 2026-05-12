import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TyposTest extends BaseTest {

    @Test
    public void checkApostropheAfterReloadPage() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/typos");

        for (int i = 0; i < 10; i++) {
            WebElement element = driver.findElement(By.xpath("//p[2]"));
            String secondLineText = element.getText();
            softAssert.assertEquals(secondLineText, "Sometimes you'll see a typo, other times you won't.", "Итерация " + i + " — текст не совпал");
            driver.navigate().refresh();
        }
        softAssert.assertAll();
    }
}
