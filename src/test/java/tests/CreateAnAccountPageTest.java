package tests;


import com.mifmif.common.regex.Generex;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.concurrent.TimeUnit;

import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.rgb;
import static org.junit.Assert.assertEquals;

public class CreateAnAccountPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private HeaderPage headerPage;
    private SignIn signIn;
    private RegistrationForm registrationForm;
    private MyAccountPage myAccountPage;
    private String email;
    private String password;

    @BeforeClass
    public static void pathSetup(){
        //System.setProperty("webdriver.chrome.driver", "/Users/Marek/IdeaProjects/Junit/jdqzl1-selenium/src/test/java/chrome/chromedriver");
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setup (){
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        this.homePage = PageFactory.initElements(this.driver, HomePage.class);
        this.headerPage = PageFactory.initElements(this.driver, HeaderPage.class);
        this.signIn = PageFactory.initElements(this.driver, SignIn.class);
        this.registrationForm = PageFactory.initElements(this.driver, RegistrationForm.class);
        this.myAccountPage = PageFactory.initElements(this.driver, MyAccountPage.class);
    }


    @Test
    public void createAnAccountWithProperData(){
        homePage.goToHomePage();
        headerPage.signInPageInHeaderClick();
        this.email = signIn.setEmailForCreatingAccount();
        signIn.submitButtonClick();
        registrationForm.setTitleMrRadioButton();
        registrationForm.setCustomerFirstNameField();
        registrationForm.setCustomerLastNameField();
        assertEquals("rgba(156, 155, 155, 1)", registrationForm.getFirstNameInputColor());
        this.password = registrationForm.setPasswordFieldForCreatingAccount();
        registrationForm.setDayInDateOfBirthDropdown();
        registrationForm.setMonthInDateOfBirthDropdown();
        registrationForm.setYearInDateOfBirthDropdown();
        registrationForm.clearName();
        registrationForm.setNameInYourAddressSection();
        registrationForm.setCompanyInAddressSection();
        registrationForm.setAddressInAdressSection();
        registrationForm.setCityInAddressSection();
        registrationForm.setStateInAddressSection();
        registrationForm.setPostalCodeInAdessSection();
        registrationForm.setMobilePhoneInAddressSection();
        registrationForm.clickRegisterButton();
        assertEquals("MY ACCOUNT", myAccountPage.myAccountTextOnPageIsDisplayed());
        myAccountPage.clickSignOutButton();
        signIn.enterMailinEmailField(email);
        signIn.enterPasswordInPassworField(password);
        signIn.clickSignInButton();
        assertEquals("MY ACCOUNT", myAccountPage.myAccountTextOnPageIsDisplayed());

    }

    }



