import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Login{

            WebDriver driver;

    public Login(WebDriver driver) {
            this.driver = driver;

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("k2774546@nwytg.com");
        driver.findElement(By.id("passwd")).sendKeys("qwerty");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        }


    }

