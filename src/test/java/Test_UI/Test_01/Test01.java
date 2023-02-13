package Test_UI.Test_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Wait;

public class Test01 {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cydeo.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quit() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void test01() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.linkText("Checkboxes")).click();

        if (driver.findElement(By.id("box1")).isSelected()) {
            System.out.println("selected");
        } else {
            driver.findElement(By.id("box1")).click();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.className("nav-link")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,700)");

    }
    @DisplayName("JavaScript Executor")
    @Test
    public void test02(){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;

js.executeScript("window.scrollBy(0,700)");

    }
    @Test
    public void test03(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        Wait.wait(3);

        System.out.println("text: "+driver.findElement(By.xpath("//div[@class='radio'][4] /input/following-sibling::label")).getText());
        System.out.println("Attribute: "+driver.findElement(By.id("green")).getAttribute("type"));

        System.out.println(driver.findElement(By.xpath("//div[@class='radio'][5] /input/following-sibling::label")).getText());

        driver.findElement(By.xpath("//div[@class='radio'][5] /input/following-sibling::label"));

    }
}


