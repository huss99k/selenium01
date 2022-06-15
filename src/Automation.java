import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.*;
import java.time.Duration;

public class Automation {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/hussainnaeem/Documents/browserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

          String expected = "Welcome to Duotify!";
          String actual = driver.getTitle();


            Assert.assertEquals(actual, expected);
            System.out.println("Title is Ok ::");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.findElement(By.id("hideLogin")).click();


        //   ArrayList<String> obj = new ArrayList<>();


        driver.findElement(By.name("username")).sendKeys("DK1993");
        driver.findElement(By.name("firstName")).sendKeys("Hussain");
        driver.findElement(By.name("lastName")).sendKeys("Ali");
        driver.findElement(By.name("email")).sendKeys("huss3k@gmail.com");
        driver.findElement(By.name("email2")).sendKeys("huss3k@gmail.com");
        driver.findElement(By.name("password")).sendKeys("barcelona1975");
        driver.findElement(By.name("password2")).sendKeys("barcelona1975");
        driver.findElement(By.name("registerButton")).click();
        String previous =  "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";

          String current =  driver.getCurrentUrl();
          Assert.assertEquals(previous,current);
          System.out.println("Current Url Matches Expected Url !!..");

          String name = driver.findElement(By.id("nameFirstAndLast")).getText();

         Assert.assertEquals(name,"Hussain Ali");
           System.out.println("IT is Showing Name Correctly on Homepage");


        driver.findElement(By.id("nameFirstAndLast")).click();


      String name2 = driver.findElement(new By.ByXPath("//*[@id='Hussain Ali']/div/div[1]/div/h1")).getText();
            System.out.println(name2);
           Assert.assertEquals(name2,"Hussain Ali");

              System.out.println("Name Correct on logout Page!!..");


          driver.findElement(By.id("rafael")).click();











        //   String expectedErrorText = "The password you've entered is incorrect. ";

         //   Assert.assertTrue(driver.getPageSource().contains(expectedErrorText));

        }
    }

