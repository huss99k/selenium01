import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.*;
import java.time.Duration;

public class Automation {

    public static void main(String[] args) {


        System.out.println("=========================================");
        System.out.println("Welcome To Duotify Application Automation");
        System.out.println("=========================================");
        System.out.println("");
         Scanner scan = new Scanner(System.in);
        System.out.println("Would like start Automation: Please enter True or false");
        boolean condition = scan.nextBoolean();
        while(condition == true){
            System.out.println("Please Enter Username");
            String username = scan.nextLine();
            System.out.println("Please Enter Email");
            String email = scan.nextLine();
            System.out.println("You've Entered: " + username + " , " + email);
            List<String> list = new ArrayList<>();
            list.add(username);
            list.add(email);


            System.setProperty("webdriver.chrome.driver", "/Users/hussainnaeem/Documents/browserDrivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

            String expected = "Welcome to Duotify!";
            String actual = driver.getTitle();


            Assert.assertEquals(actual, expected);
            System.out.println("Title is Ok ::");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.findElement(By.id("hideLogin")).click();


            driver.findElement(By.name("username")).sendKeys(list.get(0));
            driver.findElement(By.name("firstName")).sendKeys("Hussain");
            driver.findElement(By.name("lastName")).sendKeys("Ali");
            driver.findElement(By.name("email")).sendKeys(list.get(1));
            driver.findElement(By.name("email2")).sendKeys(list.get(1));
            driver.findElement(By.name("password")).sendKeys("barcelona1975");
            driver.findElement(By.name("password2")).sendKeys("barcelona1975");
            driver.findElement(By.name("registerButton")).click();
            String previous = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";

            String current = driver.getCurrentUrl();
            Assert.assertEquals(previous, current);
            System.out.println("Current Url Matches Expected Url !!..");

            String name = driver.findElement(By.id("nameFirstAndLast")).getText();

            Assert.assertEquals(name, "Hussain Ali");
            System.out.println("IT is Showing Name Correctly on Homepage");


            driver.findElement(By.id("nameFirstAndLast")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            String name2 = driver.findElement(new By.ByXPath("//*[@class='userInfo'][h1]")).getText();
            System.out.println(name2);
            Assert.assertEquals(name2, "Hussain Ali");

            System.out.println("Name Correct on logout Page!!..");


            driver.findElement(By.xpath("//button[2]")).click();

            String currentlogout = driver.getCurrentUrl();
            System.out.println(currentlogout);
            String Expected = "http://qa-duotify.us-east-2.elasticbeanstalk.com/settings.php?";
            Assert.assertEquals(currentlogout, Expected);
            System.out.println("AT sign in Page:");

            driver.findElement(By.xpath("//input[@id='loginUsername' and @name='loginUsername']")).sendKeys(list.get(0));
            driver.findElement(By.xpath("//input[@id='loginPassword' and @name='loginPassword']")).sendKeys("barcelona1975");
            driver.findElement(By.xpath("//button[@type='submit'][@name='loginButton']")).click();
            String dashboard = driver.findElement(By.xpath("//h1[@class='pageHeadingBig']")).getText();
            String Expectedheading = "You Might Also Like";
            Assert.assertEquals(dashboard, Expectedheading);
            System.out.println("Heading Correct on Dashboard");

            //Login out once again.

            driver.findElement(By.id("nameFirstAndLast")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//button[2]")).click();
            driver.close();


            //   String expectedErrorText = "The password you've entered is incorrect. ";

            //   Assert.assertTrue(driver.getPageSource().contains(expectedErrorText));
           }
        }
    }

