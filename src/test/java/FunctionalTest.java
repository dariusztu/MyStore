import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTest {
    WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        System.setProperty("webdriver.chrome.driver", "/home/dariusztu/IdeaProjects/MyStoreTesting/src/test/resources/chromedriver");
    }

    @Before
    public void setup() {

        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void goToPage(String strona) {
        driver.get(strona);
    }

    }


