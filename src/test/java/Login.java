import org.openqa.selenium.By;

public class Login extends FunctionalTest {

    public void loginToPage1() {
        pathSetup();
        setup();


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("j1138480@nwytg.com");
        driver.findElement(By.id("passwd")).sendKeys("qwerty");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }
}
