package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartObjectsPage {

    WebDriver driver;

    public CartObjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Switching between tabs

    @FindBy(css="li.step_done:nth-child(1) > a:nth-child(1)")
    private WebElement summaryTab;

    @FindBy(css="li.step_done:nth-child(2) > a:nth-child(1)")
    private WebElement signInTab;

    @FindBy(css="li.step_done:nth-child(3) > a:nth-child(1)")
    private WebElement addressTab;

    @FindBy(css="li.step_done:nth-child(4) > a:nth-child(1)")
    private WebElement shippingTab;


    //Summary


    @FindBy(css=".shopping_cart > a:nth-child(1)")
    private WebElement shoppingcartbutton;

    @FindBy(css=".standard-checkout")
    private WebElement proceedtocheckoutbutton;

    @FindBy(css=".icon-minus")
    private WebElement substractbutton;

    @FindBy(css=".icon-plus")
    private WebElement addbutton;

    @FindBy(css=".icon-trash")
    private WebElement deleteButton;

    //Address objects

    @FindBy(css="#id_address_delivery")
    private WebElement choosedeliveryaddress;

    @FindBy(css="#addressesAreEquals")
    private WebElement useDeliveryAddressAsTheBillingAddress;

    @FindBy(css="#address_delivery > li:nth-child(8) > a:nth-child(1) > span:nth-child(1)")
    private WebElement updateYourDeliveryAddress;

    @FindBy(css="#address_invoice > li:nth-child(8) > a:nth-child(1) > span:nth-child(1)")
    private WebElement updateYourBillingAddress;

    @FindBy(css=".address_add > a:nth-child(1) > span:nth-child(1)")
    private WebElement addNewAddress;

    @FindBy(css=".button-exclusive")
    private WebElement continueShopping;

    @FindBy(css="#delivery_option_71753_0")
    private WebElement shippingOptionButton;


    @FindBy(css="#cgv")
    private WebElement termsOfServiceCheck;

    @FindBy(css=".bankwire")
    private WebElement tpayByBankWire;

    @FindBy(css=".cheque")
    private WebElement payByCheck;

    @FindBy(css="textarea.form-control")
    private WebElement addressCommentForm;




    // Address comment

    public WebElement addressComment(String addressCommentkeys) {
        addressCommentForm.sendKeys(addressCommentkeys);
        return this.addressCommentForm;
    }


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

    @FindBy(css=".cart_quantity_input")
    private WebElement productQuantityNumberInSummary;

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
        dropdown1.deselectByValue("Alaska");
        return this.AddNewAddressState;
    }

    public WebElement addNewAddressCountryFill() {
        Select dropdown2 = new Select(AddNewAddressCountry);
        dropdown2.deselectByValue("United States");
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



    public WebElement addNewAddress() {
        this.addNewAddress.click();
        return this.addNewAddress;
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

    public WebElement acceptTermsOfServiceAtShippingTab() {
        this.termsOfServiceCheck.click();
        return this.termsOfServiceCheck;
    }

    public WebElement addProductQuantityInSummaryTab() {
        this.addbutton.click();
        return this.addbutton;
    }

    public WebElement substractProductQuantityInSummaryTab() {
        this.substractbutton.click();
        return this.substractbutton;
    }



    public WebElement checkIfdeleteButtonIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement returnButtonCSS;
        returnButtonCSS = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        return deleteButton;
    }

    public int checkProductQuantityInSummaryTab() {

        //int productQuantity = Integer.parseInt(this.productQuantityNumberInSummary.getAttribute("value"));
        int productQuantity = Integer.valueOf(this.productQuantityNumberInSummary.getAttribute("value"));
        return productQuantity;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
