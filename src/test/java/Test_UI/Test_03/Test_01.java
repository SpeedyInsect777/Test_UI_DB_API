package Test_UI.Test_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.Wait;

import java.util.List;

public class Test_01 {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cydeo.com/");
        driver.manage().window().fullscreen();
    }
/*@Disabled
    @AfterEach
    public void quit() {
        Wait.wait(5);
        driver.quit();
    }*/
@DisplayName("CheckBox")
    @Test
    public void test01(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='list-group-item']/a"));

        elements.stream().filter(x -> x.getText().equalsIgnoreCase("Checkboxes"))
                .findAny().ifPresent(WebElement::click);

        driver.manage().window().fullscreen();

        WebElement checkBox1 = driver.findElement(By.id("box1"));

if (!checkBox1.isSelected());
        {
            checkBox1.click();
            System.out.println("Selected ! ");
        }
    }

  @ParameterizedTest
          @ValueSource
   (
     ints={5,7,8,5,9}
    )
    public void test02(int  nums) {

        System.out.println(nums);

    }

    @ParameterizedTest
    @ValueSource(strings = {"JavaScript Alerts"})
    public void test03(String input){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='list-group-item']/a"));

        elements.stream().filter(x -> x.getText().equalsIgnoreCase(input))
                .findAny().ifPresent(WebElement::click);

        driver.manage().window().fullscreen();

driver.findElement(By.xpath("//button[contains(@class,'btn-primary')][3]")).click();
Wait.wait(3);

        Actions actions = new Actions(driver);
        actions.sendKeys("hello world").build().perform();
        Wait.wait(3);
        actions.click().build().perform();
       /* Wait.wait(3);
        actions.click().build().perform();*/
    }
}