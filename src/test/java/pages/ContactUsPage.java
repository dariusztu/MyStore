package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver driver;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "id_contact")
    private WebElement subjectHeadingDropdown;


    @FindBy(id = "email")
    private WebElement emailAdressField;


    @FindBy(xpath = "//*[@id=\"id_order\"]")
    private WebElement orderReferenceNumberField;


    @FindBy(xpath = "//*[@id=\"fileUpload\"]")
    private WebElement attachFileField;


    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement messageField;


    @FindBy(id = "submitMessage")
    private WebElement sendButton;


    public void pressSubmitButton() {
        sendButton.click();
    }
    public void insertEmailAdress(String email) {
        emailAdressField.sendKeys(email);
    }
    public void insertOrderReferenceNumber(String phrase) {
        orderReferenceNumberField.sendKeys(phrase);
    }
    public void attachFileFromLocalComputer(String pathToFile) {
        attachFileField.sendKeys(pathToFile);
    }
    public void insertTextToMessageField(String phrase) {
        messageField.sendKeys(phrase);
    }

    public void selectSubjectHeading(int id) {
        Select dropdown = new Select(subjectHeadingDropdown);
        dropdown.selectByIndex(id);
    }

    public WebElement getSubjectHeadingDropdown() {
        return subjectHeadingDropdown;
    }

    public WebElement getEmailAdressField() {
        return emailAdressField;
    }

    public WebElement getOrderReferenceNumberField() {
        return orderReferenceNumberField;
    }

    public WebElement getAttachFileField() {
        return attachFileField;
    }

    public WebElement getMessageField() {
        return messageField;
    }

    public WebElement getSendButton() {
        return sendButton;
    }
}
