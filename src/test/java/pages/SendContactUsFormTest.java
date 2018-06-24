package pages;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class SendContactUsFormTest {
    private WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        System.setProperty("webdriver.chrome.driver", "/home/michalmojek/IdeaProjects/MyStore2/src/test/resources/chromedriver");

    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void givenCorrectDataAndSendContactUsForm() {

        this.driver.get("http://automationpractice.com/index.php");
      driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
        Select selectSubjectHeading = new Select(driver.findElement(By.id("id_contact")));
        selectSubjectHeading.selectByIndex(1);
        driver.findElement(By.id("email")).sendKeys("Rob123@o2.pl");
        driver.findElement(By.xpath("//*[@id=\"id_order\"]")).sendKeys("123456789");

        //adding photo
        driver.findElement(By.xpath("//*[@id=\"fileUpload\"]")).sendKeys("/home/michalmojek/Pulpit/slawomir.jpeg");
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("This is message to contact us form");
        driver.findElement(By.xpath("//*[@id=\"submitMessage\"]/span")).click();

        //assert checking that form was send correctly
        assertEquals("Your message has been successfully sent to our team.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());

    }

}
