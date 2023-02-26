package Test_UI.Test_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Wait;

import java.awt.*;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test01 {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @AfterEach
    public void quit(){
        Wait.wait(4);
        driver.quit();
    }
    @Test
    public void test01(){

        driver.get("http://practice.cydeo.com/");
        driver.manage().window().fullscreen();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor js =  (JavascriptExecutor) driver;
Wait.wait(3);
        js.executeScript("window.scrollBy(0,700)");

        List<WebElement> elementList = driver.findElements(By.xpath("//li/a"));

   //     elementList.stream().forEach(x-> System.out.println(x.getText()));

        elementList.stream().filter(x->x.getText().equalsIgnoreCase("Form Authentication")).findAny().ifPresent(WebElement::click);

        List<WebElement> usernamePassword = driver.findElements(By.xpath("//div/input"));

        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

      //  usernamePassword.stream().forEach(x-> System.out.println( x.getAttribute("name")));

        usernamePassword.stream().filter(x->x.getAttribute("name").equalsIgnoreCase("username"))
                .findAny().ifPresent(x-> x.sendKeys("tomsmith"));

        usernamePassword.stream().filter(x->x.getAttribute("name").equalsIgnoreCase("password"))
                .findAny().ifPresent(x-> x.sendKeys("SuperSecretPassword"));
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
driver.findElement(By.id("wooden_spoon")).click();
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
driver.findElement(By.id("//div[@id='flash-messages']//div")).getText();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

driver.findElement(By.xpath("//li/a")).click();





    }
}
