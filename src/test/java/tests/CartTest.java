package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import loggers.MainLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.*;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    private Logger CartTestsLogger = LogManager.getLogger(CartTest.class);
    @BeforeClass
    public static void pathSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        driver = new ChromeDriver();

        CartTestsLogger.info("Setting up ChromeDriver on " + WebDriverManager.config().getOs() +
        " " + WebDriverManager.config().getArchitecture());

    }


    public void loginToPage() {


        LoginPage nowylogin = new LoginPage(this.driver);


    }


    @After
    public void tearDown() {
        driver.quit();
        CartTestsLogger.info("Closing ChromeDriver");
    }



    @Test
    public void passIfTrueIfGoToCartIsSuccessfull() {
        homePageObject = new HomePage(driver);
        homePageObject.goToHomePage();
        driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).click();
        assertThat(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order")).isTrue();
        assertThat((driver.getTitle()).equals("Order - My Store")).isTrue();
    }

    @Test
    public void passIfProceedToCheckOutOpen() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = PageFactory.initElements(this.driver, CartObjectsPage.class);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);

        shoppingCartSummaryPageObject.goToPage();
        assertThat(shoppingCartSummaryPageObject.addressTextGetText()).isEqualTo("03. Address");
        assertThat(shoppingCartSummaryPageObject.addressTextButtonReturnColor()).isEqualTo("#000000");

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

        assertThat(cartObjectsObject.checkIfdeleteButtonIsVisible().isDisplayed()).isTrue();


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
        assertThat(cartObjectsObject.checkProductQuantityInSummaryTab()).isGreaterThan(1);
        cartObjectsObject.substractProductQuantityInSummaryTab();
        cartObjectsObject.refreshPage();
        assertThat(cartObjectsObject.checkProductQuantityInSummaryTab()).isLessThan(2);
    }

    @Test
    public void passIfIfDeliveryAddressAddProperly() {


        myAddressesPageObject = new MyAddressesPage(driver);
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        shoppingCartSummaryPageObject = new ShoppingCartSummaryPage(driver);
        myAccountPageObject = new MyAccountPage(driver);
        loginPagePageObject = new LoginPage(driver);
        //Go to MyAddresses Page
        myAddressesPageObject.goToPage();
        myAddressesPageObject.addNewAddressButtonClick();
        //Fill new user address
        cartObjectsObject.addNewAddressFirstNameFill("Abcdef");
        cartObjectsObject.addNewAddressLastNameFill("DSdsfd");
        cartObjectsObject.addNewAddressCompanyFill("Google");
        cartObjectsObject.addNewAddressAddressFill("Abc 2");
        cartObjectsObject.addNewAddressAddressLine2Fill("Okg 3");
        cartObjectsObject.addNewAddressCityFill("Warsaw");
        cartObjectsObject.addNewAddressStateFill();
        cartObjectsObject.addNewAddressZipPostalCodeFill("22333");
        cartObjectsObject.addNewAddressCountryFill();
        cartObjectsObject.addNewAddressHomePhoneFill("123456789");
        cartObjectsObject.addNewAddressMobilePhoneFill("111222333");
        cartObjectsObject.addressComment("razdwatrzy");
        cartObjectsObject.addNewAddressAddressForFutureReferenceFill("ptwew");

        List<WebElement> errors = driver.findElements(By.cssSelector("form-error"));
        assertThat((errors).contains("form-error")).isFalse();

    }

}







