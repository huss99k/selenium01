import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.*;
import java.time.Duration;

public class ClassTask {

    //xccscs

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","/Users/hussainnaeem/Documents/browserDrivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.dice.com/");

            driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
            driver.findElement(By.id("google-location-search")).sendKeys("Washington DC");
            driver.findElement(By.id("submitSearch-button")).click();

               // driver.findElement(By.id("pageSize_2")).click();

           List<WebElement> elements = driver.findElements(By.xpath("//a[@data-cy ='card-title-link']"));

           Assert.assertEquals(20,elements.size());

           for(WebElement element : elements){
               Assert.assertTrue(element.getText().contains("SDET"));
           }

            Assert.assertTrue(driver.getTitle().contains("SDET"));

           driver.quit();













        }

        }
