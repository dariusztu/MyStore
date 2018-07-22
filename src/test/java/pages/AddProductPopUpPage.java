package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPopUpPage {

    WebDriver driver;


    public AddProductPopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="a.btn:nth-child(2) > span:nth-child(1)")
    private WebElement proceedToCheckoutButton;

    public void proceedToCheckoutButtonClick() {
        proceedToCheckoutButton.click();
    }
}
