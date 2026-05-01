import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // Options - настройка нашего браузера перез запуском
        ChromeOptions options = new ChromeOptions();
        // открытие браузера во весь экран
        options.addArguments("--start-maximized");
        // открытие браузера в инкогнито
        options.addArguments("--incognito");
        // открытие браузера без попапов
        options.addArguments("--disable-notifications");
        // открытие браузера без UI интерфейса
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //driver.manage().window().maximize();
        //driver.manage().window().minimize(); // сворачивает браузер
        //driver.manage().window().fullscreen(); // окно во весь экран
        //driver.manage().window().setSize(new Dimension(1920,1080)); // определенное разрешение окна
        //driver.manage().window().setPosition(new Point(100,100)); // указать позицию открытия окна
        //время ожидания появления элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void test(){
        driver.get("https://www.onliner.by/");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName() + " :" + cookie.getValue());
        }
        Cookie authCookie = new Cookie("session_id", "value");
        driver.manage().addCookie(authCookie);
        //System.out.println(driver.manage().window().getSize()); //вернут размер окна
    }

    @Test
    public void test1(){
        driver.get("https://www.onliner.by/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //driver.navigate().refresh();
        String mainHandle = driver.getWindowHandle();
        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://catalog.onliner.by/");
        String catalogHandle = driver.getWindowHandle();
        driver.switchTo().window(mainHandle);
        driver.switchTo().window(catalogHandle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
