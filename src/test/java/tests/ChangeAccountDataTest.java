package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class ChangeAccountDataTest {

    private HomePage homePage;
    private WebDriver driver;
    private HeaderPage headerPage;
    private Login login;

    @BeforeClass
    public static void pathSetup() {
        //System.setProperty("webdriver.chrome.driver", "/home/michalmojek/IdeaProjects/MyStore2/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.homePage = PageFactory.initElements(this.driver, HomePage.class);
        this.headerPage = PageFactory.initElements(this.driver, HeaderPage.class);
        this.login = PageFactory.initElements(this.driver, Login.class);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ChangeCreatedAccountDataTest() {
        homePage.goToHomePage();
        headerPage.signInPageInHeaderClick();
        login.fillEmailForm();
        login.fillPasswdForm();
        login.clickSubmitLoginButton();
        headerPage.setMyAccountButtonClick();




    }




}