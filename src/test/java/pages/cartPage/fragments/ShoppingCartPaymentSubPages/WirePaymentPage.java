package pages.cartPage.fragments.ShoppingCartPaymentSubPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WirePaymentPage {

    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment";

    public WirePaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".page-subheading")
    private WebElement headingTextBankWire;

    public void goToPage(){
        driver.get(url);
    }

    public String headingTextBankWireGetText() {
        String text = headingTextBankWire.getText();
        return text;
    }
}
