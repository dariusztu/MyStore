package pages.accountCreationPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddress {
    WebDriver driver;

    @FindBy(css = ".account_creation:nth-child(2)  #firstname")
    private WebElement firstName;

    @FindBy(css = ".account_creation:nth-child(2)  #lastname")
    private WebElement lastName;

    @FindBy(css = ".account_creation:nth-child(2)  #company")
    private WebElement company;

    @FindBy(css = ".account_creation:nth-child(2)  #address1")
    private WebElement address1;

    @FindBy(css = ".account_creation:nth-child(2)  #address2")
    private WebElement address2;

    @FindBy(css = ".account_creation:nth-child(2)  #city")
    private WebElement city;

    @FindBy(css = ".account_creation:nth-child(2)  #uniform-id_state")
    private WebElement state;

    @FindBy(css = ".account_creation:nth-child(2)  #postcode")
    private WebElement zipPostalCode;

    @FindBy(css = ".account_creation:nth-child(2)  #uniform-id_country")
    private WebElement country;

    @FindBy(css = ".account_creation:nth-child(2)  #other")
    private WebElement additionalInformation;

    @FindBy(css = ".account_creation:nth-child(2)  #phone")
    private WebElement phone;

    @FindBy(css = ".account_creation:nth-child(2)  #phone_mobile")
    private WebElement mobilePhone;

    @FindBy(css = ".account_creation:nth-child(2)  #alias")
    private WebElement assignAnAddressAlias;

    @FindBy(css = ".submit #submitAccount")
    private WebElement submitButton;


    public YourAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
