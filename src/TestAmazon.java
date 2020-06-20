import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAmazon
{

    WebDriver driver = null;

    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.gecko.driver", "/Users/mohidulislam/BrooklynCollege/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp()
    {
        driver.close();
    }

    @Test
    public void testTitle()
    {
        String title = driver.getTitle();
        System.out.println(title);
        SoftAssert softAssert = new SoftAssert();
        try
        {
            softAssert.assertEquals(title, "Amazon.com:  Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
                    "Title did not match. So you need to double check");
        }
        catch(Exception ex)
        {
            System.out.println("Title did not match. So you need to double check");
        }
    }

    @Test
    public void testTypingOnSearchBox()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java books", Keys.ENTER);

    }

    @Test
    public void testTypingOnSearchBoxFromList() throws InterruptedException
    {
        List<String> list = TestData.getListOfItems();

        for(int i = 0; i < list.size(); i++)
        {
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(list.get(i), Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.id("twotabsearchtextbox")).clear();
        }
    }
}
