package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import pages.cartPage.CartObjectsPage;
import pages.cartPage.fragments.ShoppingCartSummaryPage;

import java.util.List;

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
        homePageObject.getHomePagecartButtonClick();
        assertThat(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=order")).isTrue();
        assertThat((driver.getTitle()).equals("Order - My Store")).isTrue();
    }

    @Test
    public void passIfProceedToCheckOutOpen() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = PageFactory.initElements(this.driver, CartObjectsPage.class);
        cartObjectsObject.shoppingCartSummaryPage.goToPage();
        assertThat(cartObjectsObject.shoppingCartSummaryPage.addressTextGetText()).isEqualTo("03. Address");
        assertThat(cartObjectsObject.shoppingCartSummaryPage.addressTextButtonReturnColor()).isEqualTo("#000000");

    }

    @Test
    public void passIfDeleteButtonIsClickable() {
        loginPagePageObject = new LoginPage(driver);
        CartTestsLogger.info("Logging in using static login and password");
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        sampleProductPageObject = new SampleProductPage(driver);
        addProductPopUpPageObject = new AddProductPopUpPage(driver);
        sampleProductPageObject.goToPage();
        sampleProductPageObject.addToCartButtonClick();
        addProductPopUpPageObject.proceedToCheckoutButtonClick();
        cartObjectsObject.shoppingCartSummaryPage.goToPage();
        assertThat(cartObjectsObject.shoppingCartSummaryPage.checkIfdeleteButtonIsClickable().isDisplayed()).isTrue();



    }


    @Test
    public void passIfProductQuantityAddDeleteWorks() {
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        sampleProductPageObject = new SampleProductPage(driver);
        addProductPopUpPageObject = new AddProductPopUpPage(driver);
        //Login
        loginPagePageObject = new LoginPage(driver);
        CartTestsLogger.info("Logging in using static login and password");
        // Add random product to cart
        sampleProductPageObject.goToPage();
        sampleProductPageObject.addToCartButtonClick();
        addProductPopUpPageObject.proceedToCheckoutButtonClick();
        cartObjectsObject.shoppingCartSummaryPage.goToPage();

        int quantityBefore = cartObjectsObject.shoppingCartSummaryPage.checkProductQuantityInSummaryTab();
        cartObjectsObject.shoppingCartSummaryPage.addProductQuantityInSummaryTab();
        cartObjectsObject.refreshPage();
        //Assert that product quantity is as required
        assertThat(cartObjectsObject.shoppingCartSummaryPage.checkProductQuantityInSummaryTab()).isGreaterThan(1);
        cartObjectsObject.shoppingCartSummaryPage.substractProductQuantityInSummaryTab();
        cartObjectsObject.refreshPage();
        assertThat(cartObjectsObject.shoppingCartSummaryPage.checkProductQuantityInSummaryTab()).isLessThan(2);


    }

    @Test
    public void passIfIfDeliveryAddressAddProperly() {


        myAddressesPageObject = new MyAddressesPage(driver);
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        loginPagePageObject = new LoginPage(driver);
        CartTestsLogger.info("Logging in using static login and password");
        //Go to MyAddresses Page
        myAddressesPageObject.goToPage();
        myAddressesPageObject.addNewAddressButtonClick();
        //Fill new user address
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressFirstNameFill("Abcdef");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressLastNameFill("DSdsfd");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressCompanyFill("Google");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressAddressFill("Abc 2");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressAddressLine2Fill("Okg 3");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressCityFill("Warsaw");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressStateFill();
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressZipPostalCodeFill("22333");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressCountryFill();
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressHomePhoneFill("123456789");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressMobilePhoneFill("111222333");
        cartObjectsObject.shoppingCartAddressesPage.addressComment("razdwatrzy");
        cartObjectsObject.shoppingCartAddressesPage.addNewAddressAddressForFutureReferenceFill("ptwew1234");

        List<WebElement> errors = driver.findElements(By.cssSelector("form-error"));
        assertThat((errors).contains("form-error")).isFalse();
        cartObjectsObject.shoppingCartAddressesPage.acceptNewAddress();

        assertThat(driver.getPageSource().contains("ptwew1234")).isTrue();




    }

    @Test
    public void passIfTOSCheckedAbleToProceed() {

        myAddressesPageObject = new MyAddressesPage(driver);
        homePageObject = new HomePage(driver);
        cartObjectsObject = new CartObjectsPage(driver);
        loginPagePageObject = new LoginPage(driver);
        sampleProductPageObject = new SampleProductPage(driver);
        addProductPopUpPageObject = new AddProductPopUpPage(driver);
        CartTestsLogger.info("Logging in using static login and password");
        sampleProductPageObject.goToPage();
        sampleProductPageObject.addToCartButtonClick();
        addProductPopUpPageObject.proceedToCheckoutButtonClick();
        cartObjectsObject.shoppingCartSummaryPage.goToPage();;
        cartObjectsObject.proceedtocheckoutbuttonClick();
        cartObjectsObject.shoppingCartAddressesPage.addressPageProceedButtonClick();
        cartObjectsObject.shoppingCartShippingPage.acceptTermsOfServiceAtShippingTab();
        cartObjectsObject.proceedtocheckoutbuttonClick();

        assertThat(cartObjectsObject.shoppingCartPaymentPage.getHeaderTextPayment()).contains("PLEASE CHOOSE YOUR PAYMENT METHOD");


    }

}







