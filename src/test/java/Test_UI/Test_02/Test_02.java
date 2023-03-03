package Test_UI.Test_02;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_02 {

    Faker faker = new Faker();
    WebDriver driver;


    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cydeo.com/");
        driver.manage().window().fullscreen();
    }

    @AfterEach
    public void quit() {
        Wait.wait(5);
        driver.quit();
    }

    @Test
    public void test01() {



        JavascriptExecutor js = (JavascriptExecutor) driver;

        String main = driver.getWindowHandle();
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='list-group-item']/a"));

        js.executeScript("window.scroll(0,1000)");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        elements.stream().filter(x -> x.getText().equalsIgnoreCase("New tab")).findAny().ifPresent(WebElement::click);

        String main2 = driver.getWindowHandle();

        Wait.wait(5);

        if(driver.getWindowHandle()!=main2){
            System.out.println("We switched window");

            driver.switchTo().window(main);
            Wait.wait(3);
            driver.navigate().back();
        }
        driver.manage().window().fullscreen();
        Wait.wait(4);
        js.executeScript("window.scroll(0,2500)");

        elements.stream().filter(x -> x.getText().equalsIgnoreCase("Web Tables")).findAny().ifPresent(WebElement::click);



    }
    @Test
    public void test02(){

        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("window.scroll(0,2500)");
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='list-group-item']/a"));


        elements.stream().filter(x -> x.getText().equalsIgnoreCase("Sortable Data Tables")).findAny().ifPresent(WebElement::click);

        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[1]")).getText();

        System.out.println(lastName);

        driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th")).click();

        String lastName2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[1]")).getText();

        System.out.println(lastName2);
    }
}



















