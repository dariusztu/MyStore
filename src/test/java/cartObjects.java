import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartObjects {

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
    private WebElement subtractbutton;

    @FindBy(css=".icon-plus")
    private WebElement addbutton;

    @FindBy(css=".icon-trash")
    private WebElement deletebutton;

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

    public void addressComment(String addressCommentkeys) {
        addressCommentForm.sendKeys(addressCommentkeys);
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

    // Add new Address sendKeys

    public void AddNewAddressFirstNameFill(String AddNewAddressFirstName) {
        this.AddNewAddressFirstName.sendKeys(AddNewAddressFirstName);
    }

    public void AddNewAddressLastNameFill(String AddNewAddressLastName) {
        this.AddNewAddressLastName.sendKeys(AddNewAddressLastName);
    }

    public void AddNewAddressLastCompanyFill(String AddNewAddressCompany) {
        this.AddNewAddressCompany.sendKeys(AddNewAddressCompany);
    }

    public void AddNewAddressLastAddressFill(String AddNewAddressAddress) {
        this.AddNewAddressAddress.sendKeys(AddNewAddressAddress);
    }

    public void AddNewAddressLastAddressLine2Fill(String AddNewAddressAddressLine2) {
        this.AddNewAddressAddressLine2.sendKeys(AddNewAddressAddressLine2);
    }

    public void AddNewAddressCityFill(String AddNewAddressCity) {
        this.AddNewAddressCity.sendKeys(AddNewAddressCity);
    }

    public void AddNewAddressStateFill(String AddNewAddressState) {
        this.AddNewAddressState.sendKeys(AddNewAddressState);
    }

    public void AddNewAddressZipPostalCodeFill(String AddNewAddressZipPostalCode) {
        this.AddNewAddressZipPostalCode.sendKeys(AddNewAddressZipPostalCode);
    }
}
