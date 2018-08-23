package pages.cartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cartPage.fragments.*;

public class CartObjectsPage {

    WebDriver driver;
    public ShoppingCartAddressesPage shoppingCartAddressesPage;
    public ShoppingCartPaymentPage shoppingCartPaymentPage;
    public ShoppingCartShippingPage shoppingCartShippingPage;
    public ShoppingCartSignInPage shoppingCartSignInPage;
    public ShoppingCartSummaryPage shoppingCartSummaryPage;

    public CartObjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        shoppingCartAddressesPage = new ShoppingCartAddressesPage(driver);
        shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
        shoppingCartShippingPage = new ShoppingCartShippingPage(driver);
        shoppingCartSignInPage = new ShoppingCartSignInPage(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
    }

    // Switching between tabs

    @FindBy(css="li.step_done:nth-child(1) > a:nth-child(1)")
    private WebElement summaryTab;

    @FindBy(css="li.step_done:nth-child(2) > a:nth-child(1)")
    private WebElement signInTab;

    @FindBy(css="li.step_done:nth-child(3) > a:nth-child(1)")
    private WebElement addressTab;

    @FindBy(css="li.step_done:nth-child(4) > a:nth-child(1)")
    private WebElement shippingTab;

    //Continue shopping
    @FindBy(css=".button-exclusive")
    private WebElement continueShopping;


    //Address objects

    @FindBy(css="#id_address_delivery")
    private WebElement choosedeliveryaddress;

    @FindBy(css="#addressesAreEquals")
    private WebElement useDeliveryAddressAsTheBillingAddress;

    @FindBy(css="#address_delivery > li:nth-child(8) > a:nth-child(1) > span:nth-child(1)")
    private WebElement updateYourDeliveryAddress;

    @FindBy(css="#address_invoice > li:nth-child(8) > a:nth-child(1) > span:nth-child(1)")
    private WebElement updateYourBillingAddress;

    @FindBy(css=".address_add > a:nth-child(1) > span:nth-child(1)")
    private WebElement addNewAddress;

    @FindBy(css=".standard-checkout")
    private WebElement proceedtocheckoutbutton;




    public WebElement proceedtocheckoutbuttonClick() {
        proceedtocheckoutbutton.click();
        return proceedtocheckoutbutton;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public WebElement addNewAddress() {
        this.addNewAddress.click();
        return this.addNewAddress;
    }

}
