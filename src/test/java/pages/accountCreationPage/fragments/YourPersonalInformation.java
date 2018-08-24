package pages.accountCreationPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourPersonalInformation {
    WebDriver driver;


    @FindBy(css = ".account_creation:nth-child(1) .clearfix")
    private WebElement title;
    //Title

    @FindBy(css = ".account_creation:nth-child(1) #customer_firstname")
    private WebElement firstName;
    //    firstname
    @FindBy(css = ".account_creation:nth-child(1) #customer_lastname")
    private WebElement lastName;
    //    lastname
    @FindBy(css = ".account_creation:nth-child(1) #email")
    private WebElement email;
    //    email
    @FindBy(css = ".account_creation:nth-child(1) #passwd")
    private WebElement password;
    //password
    @FindBy(css = ".account_creation:nth-child(1) div.form-group:nth-child(7)")
    private WebElement dateOfBirth;
    //TODO    date of birth
    @FindBy(css = ".account_creation:nth-child(1) .checkbox #uniform-newsletter")
    private WebElement signUpCheckbox;
    //TODO    signup checkbox
    @FindBy(css = ".account_creation:nth-child(1) .checkbox #uniform-optin")
    private WebElement receiveCheckbox;
//TODO    receive checkbox


    public YourPersonalInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
