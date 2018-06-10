import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageObjects {

    @FindBy(id = "contact-link > a")
    private WebElement contactUsButton;

    @FindBy(id = "id_contact")
    private WebElement subjectHeadingField;

    @FindBy(id = "email")
    private WebElement emailAdress;

    @FindBy(id = "id_order")
    private WebElement orderReference;

    @FindBy(id = "fileUpload")
    private WebElement attachFile;

    @FindBy(id = "message")
    private WebElement insertMessage;

    @FindBy(id = "submitMessage")
    private WebElement submitFormButton;

    private WebDriver driver;


    public void pressContactUsButton() {
        contactUsButton.click();
    }

    public void chooseSubjectHeading() {
        Select chooseSubjectHead = new Select(driver.findElement(By.id("id_contact")));
        chooseSubjectHead.selectByIndex();
    }

    public void insertEmailAdress(String email) {
        this.emailAdress.clear();
        this.emailAdress.sendKeys(email);

    }

    public void insertOrderReference(String orderNumber) {
        this.orderReference.clear();
        this.orderReference.sendKeys(orderNumber);
    }

    public void setAttachFile(String pathToFile) {
        driver.findElement(By.id("fileUpload")).sendKeys(pathToFile);
    }

}