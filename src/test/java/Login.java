import org.openqa.selenium.By;

public class Login {
    public void loginToPage() {


        FunctionalTest test = new FunctionalTest();
        test.driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        test.driver.findElement(By.id("email")).sendKeys("j1138480@nwytg.com");
        test.driver.findElement(By.id("passwd")).sendKeys("qwerty");
        test.driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

    }
}
