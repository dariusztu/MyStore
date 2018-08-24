package pages.cartPage.fragments.ShoppingCartPaymentSubPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckPaymentPage {

    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?fc=module&module=cheque&controller=payment";

    public CheckPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".page-subheading")
    private WebElement headingTextCheckPayment;

    public void goToPage(){
        driver.get(url);
    }

    public String headingTextCheckPaymentGetText() {
        String text = headingTextCheckPayment.getText();
        return text;
    }
}
