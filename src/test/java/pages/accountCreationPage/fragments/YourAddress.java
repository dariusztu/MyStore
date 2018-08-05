package pages.accountCreationPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddress {
    WebDriver driver;

    @FindBy(css = "id_gender1")
    private WebElement titleMrRadioButton;

    @FindBy(css = "customer_firstname")
    private WebElement customerFirstNameField;

    @FindBy(css = "customer_lastname")
    private WebElement customerLastNameField;

    @FindBy(css = "passwd")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"days\"]/option[6]")
    private WebElement dayInDateOfBirthDropdown;

    @FindBy (xpath = "//*[@id=\"months\"]/option[6]")
    private WebElement monthInDateOfBirthDropdown;

    @FindBy(xpath = "//*[@id=\"years\"]/option[30]")
    private WebElement yearInDateOfBirthDropdown;

    public YourAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
