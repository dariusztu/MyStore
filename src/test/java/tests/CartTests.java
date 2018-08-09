package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import loggers.MainLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CartTests {

    private HomePage homePageObject;
    private CartObjects cartObjectsObject;
    private Login loginPageObject;
    private ShoppingCartSummaryPage shoppingCartSummaryPageObject;
    private HeaderPage headerPageObject;
    private MyAccountPage myAccountPageObject;
    private MyAddressesPage myAddressesPageObject;
    private AddProductPopUpPage addProductPopUpPageObject;
    private SampleProductPage sampleProductPageObject;
    private WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        // System.setProperty("webdriver.chrome.driver", "/home/dariusztu/IdeaProjects/MyStoreTesting/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        driver = new ChromeDriver();
        private static Logger CartTestsLogger = LogManager.getLogger(CartTests.class);
        CartTestsLogger.info("Setting up ChromeDriver");

    }


    public void loginToPage() {


        Login nowylogin = new Login(this.driver);


    }


    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void returnTrueIfGoToCartIsSuccessfull() {
        homePageObject = new HomePage(driver);
        homePageObject.goToHomePage();
        driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).click();
        assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order"));
        assertTrue((driver.getTitle()).equals("Order - My Store"));
    }

    @Test
    public void returnTrueIfProceedToCheckOutOpen() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = PageFactory.initElements(this.driver, CartObjects.class);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);

        shoppingCartSummaryPageObject.goToPage();

        assertEquals("Address", shoppingCartSummaryPageObject.addressTextGetText());

        WebDriverWait wait = new WebDriverWait(driver, 10);

        assertEquals("#000000", shoppingCartSummaryPageObject.addressTextButtonReturnColor());
    }

    @Test
    public void returnTrueIfDeleteButtonIsClickable() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjects(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPageObject.goToPage();
        assertTrue((driver.findElement(By.id("icon-trash")).isDisplayed()));
    }


    @Test
    public void returnTrueIfProductQuantityAddDeleteWorks() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjects(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        sampleProductPageObject = new SampleProductPage(driver);
        addProductPopUpPageObject = new AddProductPopUpPage(driver);
        loginPageObject = new Login(driver);
        sampleProductPageObject.goToPage();
        sampleProductPageObject.addToCartButtonClick();
        addProductPopUpPageObject.proceedToCheckoutButtonClick();
        shoppingCartSummaryPageObject.goToPage();
        // add product to Cart her  e
        int quantityBefore = cartObjectsObject.checkProductQuantityInSummaryTab();
        cartObjectsObject.addProductQuantityInSummaryTab();
        assertEquals(((cartObjectsObject.checkProductQuantityInSummaryTab()) > quantityBefore), 2);
        cartObjectsObject.substractProductQuantityInSummaryTab();
        assertEquals(((cartObjectsObject.checkProductQuantityInSummaryTab()) > quantityBefore), 1);
    }

    @Test
    public void returnTrueIfDeliveryAddressAddProperly() {



        myAddressesPageObject = new MyAddressesPage(driver);
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjects(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        myAccountPageObject = new MyAccountPage(driver);
        loginPageObject = new Login(driver);
        myAddressesPageObject.goToPage();
        myAddressesPageObject.addNewAddressButtonClick();
        cartObjectsObject.addNewAddressFirstNameFill("Abcdef");
        cartObjectsObject.addNewAddressLastNameFill("DSdsfd");
        cartObjectsObject.addNewAddressLastCompanyFill("Google");
        cartObjectsObject.addNewAddressLastAddressFill("Abc 2");
        cartObjectsObject.addNewAddressLastAddressLine2Fill("Okg 3");
        cartObjectsObject.addNewAddressCityFill("Warsaw");

    }

}







