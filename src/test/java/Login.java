import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Login {
    @Test
    public void loginToPage() {


        FunctionalTest test = new FunctionalTest();
        test.driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        test.driver.findElement(By.id("email")).sendKeys("j1138480@nwytg.com");
        test.driver.findElement(By.id("passwd")).sendKeys("qwerty");
        test.driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

    }
}
