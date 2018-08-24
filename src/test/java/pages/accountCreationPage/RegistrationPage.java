package pages.accountCreationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.accountCreationPage.fragments.YourAddress;
import pages.accountCreationPage.fragments.YourPersonalInformation;

public class RegistrationPage {
    WebDriver driver;

    public YourAddress yourAddress;
    public YourPersonalInformation yourPersonalInformation;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        yourAddress = new YourAddress(driver);
        yourPersonalInformation = new YourPersonalInformation(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-heading")
    private WebElement createAnAccountText;

    public String getCreateAnAccountText() {
        String text = createAnAccountText.getText();
        return text;
    }
}
