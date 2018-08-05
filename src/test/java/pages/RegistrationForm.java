package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

public class RegistrationForm {
    WebDriver driver;

    public void RegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"days\"]/option[6]")
    private WebElement dayInDateOfBirthDropdown;

    @FindBy (xpath = "//*[@id=\"months\"]/option[6]")
    private WebElement monthInDateOfBirthDropdown;

    @FindBy(xpath = "//*[@id=\"years\"]/option[30]")
    private WebElement yearInDateOfBirthDropdown;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement nameInYourAddressSection;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement companyInAddressSection;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement addressInAdressSection;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityInAddressSection;

    @FindBy(xpath = "//*[@id=\"id_state\"]/option[6]")
    private WebElement stateInAddressSection;

    @FindBy(id = "postcode")
    private WebElement postalCodeInAdessSection;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilePhoneInAddressSection;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;



    public String getFirstNameInputColor() {
        return customerLastNameField.getCssValue("color");

    }

    public RegistrationForm setTitleMrRadioButton() {
        titleMrRadioButton.click();
        return this;
    }

    public RegistrationForm setCustomerFirstNameField() {
        customerFirstNameField.sendKeys("FirstName");return this;
    }

    public RegistrationForm setCustomerLastNameField() {
        customerLastNameField.sendKeys("LastName");return this;
    }


    public String setPasswordFieldForCreatingAccount() {
        String generatedStringPassword = RandomStringUtils.randomAlphabetic(10);
        System.out.println("password: "+generatedStringPassword);
        String password = generatedStringPassword;
        passwordField.sendKeys(password);
        return password;
    }

   public RegistrationForm setDayInDateOfBirthDropdown(){
        dayInDateOfBirthDropdown.click();return this;
   }
    public RegistrationForm setMonthInDateOfBirthDropdown(){
        monthInDateOfBirthDropdown.click();return this;
    }

    public RegistrationForm setYearInDateOfBirthDropdown(){
        yearInDateOfBirthDropdown.click();return this;
    }

    public RegistrationForm setNameInYourAddressSection(){
        nameInYourAddressSection.sendKeys("FirstNameInAdress");return this;
    }
    public RegistrationForm setCompanyInAddressSection(){
        companyInAddressSection.sendKeys("MyCompany");return this;
    }

    public RegistrationForm setAddressInAdressSection(){
        addressInAdressSection.sendKeys("Any Address");return this;
    }

    public RegistrationForm setCityInAddressSection(){
        cityInAddressSection.sendKeys("Sample City");return this;
    }

    public RegistrationForm setStateInAddressSection(){
        stateInAddressSection.click();return this;
    }

    public RegistrationForm setPostalCodeInAdessSection(){
        postalCodeInAdessSection.sendKeys("00088");return this;
    }

    public RegistrationForm setMobilePhoneInAddressSection(){
        mobilePhoneInAddressSection.sendKeys("555-555-555");return this;
    }

    public RegistrationForm clickRegisterButton(){
        registerButton.click();return this;
    }

    public RegistrationForm clearName(){
        nameInYourAddressSection.clear();
        return this;
    }

    }
