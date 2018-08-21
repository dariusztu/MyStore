package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import loggers.MainLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.*;

public class CartTest {

    private HomePage homePageObject;
    private CartObjectsPage cartObjectsObject;
    private LoginPage loginPagePageObject;
    private ShoppingCartSummaryPage shoppingCartSummaryPageObject;
    private HeaderPage headerPageObject;
    private MyAccountPage myAccountPageObject;
    private MyAddressesPage myAddressesPageObject;
    private AddProductPopUpPage addProductPopUpPageObject;
    private SampleProductPage sampleProductPageObject;
    private WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        driver = new ChromeDriver();
       Logger CartTestsLogger = LogManager.getLogger(CartTest.class);
       CartTestsLogger.info("Setting up ChromeDriver");

    }


    public void loginToPage() {


        LoginPage nowylogin = new LoginPage(this.driver);


    }


    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void passIfTrueIfGoToCartIsSuccessfull() {
        homePageObject = new HomePage(driver);
        homePageObject.goToHomePage();
        driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).click();
        assertTrue(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order"));
        assertTrue((driver.getTitle()).equals("Order - My Store"));
    }

    @Test
    public void passIfProceedToCheckOutOpen() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = PageFactory.initElements(this.driver, CartObjectsPage.class);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);

        shoppingCartSummaryPageObject.goToPage();

        assertEquals("03. Address", shoppingCartSummaryPageObject.addressTextGetText());
        //assertThat(shoppingCartSummaryPageObject.addressTextGetText());



        assertEquals("#000000", shoppingCartSummaryPageObject.addressTextButtonReturnColor());

    }

    @Test
    public void passIfDeleteButtonIsClickable() {
        loginPagePageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        sampleProductPageObject = new SampleProductPage(driver);
        addProductPopUpPageObject = new AddProductPopUpPage(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        sampleProductPageObject.goToPage();
        sampleProductPageObject.addToCartButtonClick();
        addProductPopUpPageObject.proceedToCheckoutButtonClick();
        shoppingCartSummaryPageObject.goToPage();
        cartObjectsObject.checkIfdeleteButtonIsVisible();

        assertTrue((cartObjectsObject.checkIfdeleteButtonIsVisible().isDisplayed()));



    }


    @Test
    public void passIfProductQuantityAddDeleteWorks() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        sampleProductPageObject = new SampleProductPage(driver);
        addProductPopUpPageObject = new AddProductPopUpPage(driver);
        //Login
        loginPagePageObject = new LoginPage(driver);
        // Add random product to cart
        sampleProductPageObject.goToPage();
        sampleProductPageObject.addToCartButtonClick();
        addProductPopUpPageObject.proceedToCheckoutButtonClick();
        shoppingCartSummaryPageObject.goToPage();

        int quantityBefore = cartObjectsObject.checkProductQuantityInSummaryTab();
        cartObjectsObject.addProductQuantityInSummaryTab();
        cartObjectsObject.refreshPage();
        //Assert that product quantity is as required
        Assertions.assertThat(cartObjectsObject.checkProductQuantityInSummaryTab()).isGreaterThan(1);
        cartObjectsObject.substractProductQuantityInSummaryTab();
        cartObjectsObject.refreshPage();
        Assertions.assertThat(cartObjectsObject.checkProductQuantityInSummaryTab()).isLessThan(2);
    }

    @Test
    public void passIfIfDeliveryAddressAddProperly() {



        myAddressesPageObject = new MyAddressesPage(driver);
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        myAccountPageObject = new MyAccountPage(driver);
        loginPagePageObject = new LoginPage(driver);
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







