package Test_UI.Test_02;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Wait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class Test02 {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

   /* @AfterEach
    public void quit() {
        Wait.wait(5);
        driver.quit();
    }*/

    @Test
    public void test01() {

        driver.get("https://www.google.com/");
        String mainWindowHandle = driver.getWindowHandle();

        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Hello World");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        Wait.wait(5);
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

    @Test
    public void test02() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("http://practice.cydeo.com/");

        driver.manage().window().fullscreen();

        String mainWindowHandle = driver.getWindowHandle();

        js.executeScript("window.scrollBy(0,1000)");

        Wait.wait(5);

        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().fullscreen();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        for (String handle : allWindowHandles) {

            if (!handle.equals(mainWindowHandle)) {

                driver.switchTo().window(handle);

                Wait.wait(5);

                driver.close();
            }
        }
        //    driver.navigate().back();
        //     Wait.wait(5);
        driver.switchTo().window(mainWindowHandle);
        //      Wait.wait(5);
        //   driver.quit();
    }

    @Test
    public void test03() {

        driver.get("https://demo.automationtesting.in/");

        driver.findElement(By.id("email")).sendKeys("HelloWorld");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("enterimg")).click();

        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/input[1]")).sendKeys(faker.funnyName().name());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4'][2]/input")).sendKeys(faker.funnyName().name());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='col-md-8 col-xs-8 col-sm-8']/textarea")).sendKeys(faker.address().fullAddress());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='eid']/input")).sendKeys(faker.funnyName() + "@gmail.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        System.out.println(driver.findElement(By.xpath("//input[@value='Male']/parent::label")).getText());


        Wait.wait(4);
        driver.quit();


    }

    @Test
    public void test04() {


    }
}



