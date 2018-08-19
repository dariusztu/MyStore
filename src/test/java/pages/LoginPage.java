package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

             private WebDriver driver;
            private String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
            private String email = "k2774546@nwytg.com";
            private String passwd = "qwerty";

    public LoginPage(WebDriver driver) {
            this.driver = driver;
        PageFactory.initElements(driver, this);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        }

    @FindBy(id = "email")
    private WebElement emailForm;

    @FindBy(id = "passwd")
    private WebElement passwdForm;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement submitLoginButton;

    public void fillEmailForm() {
        emailForm.sendKeys(email);
    }

    public void fillPasswdForm() {
        emailForm.sendKeys(passwd);
    }

    public void clickSubmitLoginButton() {
        submitLoginButton.click();
    }

    public void goToLoginPage() {
        driver.get(url);
    }

    public void LoginIn() {
        goToLoginPage();
        fillEmailForm();
        fillPasswdForm();
        clickSubmitLoginButton();
    }

    }

