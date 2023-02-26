package Test_UI.Test_02;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Wait;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;

public class Test02 {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterEach
    public void quit() {
        Wait.wait(5);
        driver.quit();
    }

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

        driver.get("https://www.google.com/");

        String mainPage = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();

        Wait.wait(5);

        driver.findElement(By.name("q")).sendKeys("Selenium");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div/center/input[1]")).click();

        String link = driver.findElement(By.xpath("//div/link")).getAttribute("href");

        System.out.println("Link : " + link);

        Wait.wait(5);

        String result = driver.getWindowHandle();

        handles = driver.getWindowHandles();

        driver.switchTo().window(mainPage);

        Wait.wait(5);

        System.out.println("1 : " + mainPage);

        System.out.println("2 : " + result);

        System.out.println(handles);

    }

    @Test
    public void test05() {

        String expected = "Select your date of birth";

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dropdown")).click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

     //   String actualText = driver.findElement(By.xpath("//select[@id='year']/parent::div/h6[2]")).getText();

   //     MatcherAssert.assertThat(actualText, is(endsWithIgnoringCase(expected)));

        Select selectYear = new Select(year);

        List<WebElement> options = selectYear.getOptions();

        options.stream().filter(x -> x.getText().equalsIgnoreCase("2020")).findAny().ifPresent(WebElement::click);

       // options.forEach(x->System.out.println(x.getText()));

        WebElement elementMonth = driver.findElement(By.xpath("//select[@id='month']"));

        Select selectMonth = new Select(elementMonth);

        selectMonth.getOptions().stream().filter(x->x.getText().equalsIgnoreCase("May")).findAny().ifPresent(WebElement::click);

   WebElement elementDays = driver.findElement(By.xpath("//select[@id='day']"));

   Select selectDay = new Select(elementDays);

  selectDay.getOptions().stream().filter(x->x.getText().equalsIgnoreCase("20")).findAny().ifPresent(WebElement::click);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        select.getOptions().stream().filter(x -> x.getText().equalsIgnoreCase("ohio")).findAny().ifPresent(WebElement::click);

     WebElement simpleOptions =  driver.findElement(By.xpath("//select[@id='dropdown']"));

     Select selectOptions = new Select(simpleOptions);

     selectOptions.getOptions().stream().forEach(x-> System.out.println(x.getText()));

     selectOptions.getOptions().stream().filter(x->x.getText().equalsIgnoreCase("Option 2")).findAny().ifPresent(WebElement::click);



    }
}




