package Test_UI.Test_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Wait;

public class Test_01 {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cydeo.com/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,700)");
        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        driver.findElement(By.linkText("JavaScript Alerts")).click();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }

        driver.quit();
    }
}
