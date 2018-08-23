package pages.cartPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartAddressesPage {
    WebDriver driver;

    private String url = "http://automationpractice.com/index.php?controller=order&step=1";

    public ShoppingCartAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="textarea.form-control")
    private WebElement addressCommentForm;

    // Proceed different button
    @FindBy(css="[type='submit'][name='processAddress']")
    private WebElement addressPageProceedButton;


    // Add new address page

    @FindBy(css="#firstname")
    private WebElement AddNewAddressFirstName;

    @FindBy(css="#lastname")
    private WebElement AddNewAddressLastName;

    @FindBy(css="#company")
    private WebElement AddNewAddressCompany;

    @FindBy(css="#address1")
    private WebElement AddNewAddressAddress;

    @FindBy(css="#address2")
    private WebElement AddNewAddressAddressLine2;

    @FindBy(css="#city  ")
    private WebElement AddNewAddressCity;

    @FindBy(css="#id_state")
    private WebElement AddNewAddressState;

    @FindBy(css="#postcode")
    private WebElement AddNewAddressZipPostalCode;

    @FindBy(css="#id_country")
    private WebElement AddNewAddressCountry;

    @FindBy(css="#phone")
    private WebElement AddNewAddressHomePhone;

    @FindBy(css="#phone_mobile")
    private WebElement AddNewAddressMobilePhone;

    @FindBy(css="#other")
    private WebElement AddNewAddressAdditionalInformation;

    @FindBy(css="#alias")
    private WebElement AddNewAddressAddressForFutureReference;

    @FindBy(css="#submitAddress")
    private WebElement saveButtonAtAddNewAddress;

    @FindBy(css=".btn-defaul > span:nth-child(1)")
    private WebElement backToYourAddressesButton;

    @FindBy(css="#address_invoice > li:nth-child(7) > a:nth-child(1) > span:nth-child(1)")
    private WebElement updateYourBillingAddressButton;

    // Add new Address sendKeys

    public WebElement addNewAddressFirstNameFill(String AddNewAddressFirstName) {
        this.AddNewAddressFirstName.sendKeys(AddNewAddressFirstName);
        return this.AddNewAddressFirstName;
    }

    public WebElement addNewAddressLastNameFill(String AddNewAddressLastName) {
        this.AddNewAddressLastName.sendKeys(AddNewAddressLastName);
        return this.AddNewAddressLastName;
    }

    public WebElement addNewAddressCompanyFill(String AddNewAddressCompany) {
        this.AddNewAddressCompany.sendKeys(AddNewAddressCompany);
        return this.AddNewAddressCompany;
    }

    public WebElement addNewAddressAddressFill(String AddNewAddressAddress) {
        this.AddNewAddressAddress.sendKeys(AddNewAddressAddress);
        return this.AddNewAddressAddress;
    }

    public WebElement addNewAddressAddressLine2Fill(String AddNewAddressAddressLine2) {
        this.AddNewAddressAddressLine2.sendKeys(AddNewAddressAddressLine2);
        return this.AddNewAddressAddressLine2;
    }

    public WebElement addNewAddressCityFill(String AddNewAddressCity) {
        this.AddNewAddressCity.sendKeys(AddNewAddressCity);
        return this.AddNewAddressCity;
    }

    public WebElement addNewAddressStateFill() {
        Select dropdown1 = new Select(AddNewAddressState);
        dropdown1.getOptions();
        dropdown1.selectByIndex(1);
        return this.AddNewAddressState;
    }

    public WebElement addNewAddressCountryFill() {
        Select dropdown2 = new Select(AddNewAddressCountry);
        dropdown2.selectByIndex(0);
        return this.AddNewAddressCountry;
    }

    public WebElement addNewAddressZipPostalCodeFill(String AddNewAddressZipPostalCode) {
        this.AddNewAddressZipPostalCode.sendKeys(AddNewAddressZipPostalCode);
        return this.AddNewAddressZipPostalCode;
    }

    public WebElement addNewAddressHomePhoneFill(String AddNewAddressHomePhone) {
        this.AddNewAddressHomePhone.sendKeys(AddNewAddressHomePhone);
        return this.AddNewAddressHomePhone;
    }

    public WebElement addNewAddressMobilePhoneFill(String AddNewAddressMobilePhone) {
        this.AddNewAddressMobilePhone.sendKeys(AddNewAddressMobilePhone);
        return this.AddNewAddressMobilePhone;
    }

    public WebElement addNewAddressAddressForFutureReferenceFill(String AddNewAddressAddressForFutureReference) {
        this.AddNewAddressAddressForFutureReference.sendKeys(AddNewAddressAddressForFutureReference);
        return this.AddNewAddressAddressForFutureReference;
    }





    public WebElement acceptNewAddress() {
        this.saveButtonAtAddNewAddress.click();
        return this.saveButtonAtAddNewAddress;
    }

    public WebElement goBackToYourAddressess() {
        this.backToYourAddressesButton.click();
        return this.backToYourAddressesButton;
    }

    public WebElement updateYourBillingAddress() {
        this.updateYourBillingAddressButton.click();
        return this.updateYourBillingAddressButton;
    }

    // Address comment

    public WebElement addressComment(String addressCommentkeys) {
        addressCommentForm.sendKeys(addressCommentkeys);
        return this.addressCommentForm;
    }

    // Proceed button
    public  WebElement addressPageProceedButtonClick() {
        addressPageProceedButton.click();
        return  addressPageProceedButton;
    }
}
