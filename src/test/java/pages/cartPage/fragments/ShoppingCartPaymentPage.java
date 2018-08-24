package pages.cartPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.cartPage.fragments.ShoppingCartPaymentSubPages.CheckPaymentPage;
import pages.cartPage.fragments.ShoppingCartPaymentSubPages.WirePaymentPage;

public class ShoppingCartPaymentPage {

    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?controller=order&multi-shipping=";
    public CheckPaymentPage checkPaymentPage;
    public WirePaymentPage wirePaymentPage;

    public ShoppingCartPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        checkPaymentPage = new CheckPaymentPage(driver);
        wirePaymentPage = new WirePaymentPage(driver);

    }

    @FindBy(css=".bankwire")
    private WebElement payByBankWire;

    @FindBy(css=".cheque")
    private WebElement payByCheck;

    @FindBy(css=".page-heading")
    private WebElement headerTextPayment;

    public String getHeaderTextPayment() {
        String headerTextPaymentText = headerTextPayment.getText();
        return headerTextPaymentText;
    }

    public WebElement payByBankWireClick() {
        payByBankWire.click();
        return payByBankWire;
    }

    public WebElement payByCheckClick() {
        payByCheck.click();
        return payByCheck;
    }
}
