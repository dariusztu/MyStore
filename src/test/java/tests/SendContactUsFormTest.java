package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.ContactUsPage;
import pages.FooterPage;
import pages.HeaderPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class SendContactUsFormTest {
    private WebDriver driver;

    private HeaderPage headerPage;
    private HomePage homePage;
    private ContactUsPage contactUsPage;
    private FooterPage footerPage;


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
        this.footerPage = PageFactory.initElements(this.driver, FooterPage.class);
        this.contactUsPage = PageFactory.initElements(this.driver, ContactUsPage.class);
    }

    @Test
    public void givenCorrectDataAndSendContactUsForm() {

        homePage.goToHomePage();
        headerPage.getContactUsButton().click();
        contactUsPage.selectSubjectHeading(1);
        contactUsPage.insertEmailAdress("jac123@o2.pl");
        contactUsPage.insertOrderReferenceNumber("1234");
        contactUsPage.insertOrderReferenceNumber("55555555");
        contactUsPage.insertTextToMessageField("sldkfmmlkmd kdslk ndsklfnsk lndskfn dskfdn");
        contactUsPage.pressSubmitButton();

        //assert checking that form was send correctly
       assertEquals("Your message has been successfully sent to our team.",driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")));


    }

}
