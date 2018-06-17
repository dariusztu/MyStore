import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FunctionalTest {
    WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
       // System.setProperty("webdriver.chrome.driver", "/home/dariusztu/IdeaProjects/MyStoreTesting/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void goToPage(String strona) {
        driver.get(strona);
    }

    @Test
    public void  returnTrueIfGoToCartIsSuccessfull() {
            goToPage("http://automationpractice.com/index.php");
            driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).click();
            assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order"));
           assertTrue((driver.getTitle()).equals("Order - My Store"));
    }

    @Test
    public void  returnTrueIfProceedToCheckOutOpen() {
        goToPage("http://automationpractice.com/index.php?controller=order");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[3]/span"));
        assertEquals("Address", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[3]/span")).getText());

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement proceedToCheckOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[3]/span")));
        String backgroundColor = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[3]/span")).getCssValue("background-color");
        String backgroundColorHex = Color.fromString(backgroundColor).asHex().toUpperCase();

        assertEquals("#000000", backgroundColorHex);
    }
    @Test
    public void  returnTrueIfDeleteButtonIsClickable() {
        goToPage("http://automationpractice.com/index.php?controller=order");
        assertTrue((driver.findElement(By.id("icon-trash")).isDisplayed()));
    }


    }




