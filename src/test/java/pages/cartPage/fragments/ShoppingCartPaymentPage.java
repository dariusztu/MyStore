package pages.cartPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPaymentPage {

    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?controller=order&multi-shipping=";

    public ShoppingCartPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".bankwire")
    private WebElement tpayByBankWire;

    @FindBy(css=".cheque")
    private WebElement payByCheck;

    @FindBy(css=".page-heading")
    private WebElement headerTextPayment;

    public String getHeaderTextPayment() {
        String headerTextPaymentText = headerTextPayment.getText();
        return headerTextPaymentText;
    }
}
