package pages.cartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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


    @FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/ul/li[3]/span")
    private WebElement addressTextButton;

    @FindBy(xpath="//*[@id=\"order_step\"]/li[2]/span")
    private WebElement signInTextButton;

    @FindBy(xpath="//*[@id=\"order_step\"]/li[4]/span")
    private WebElement shippingTextButton;

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

    public String addressTextButtonReturnColor() {
        String backgroundColor = addressTextButton.getCssValue("background-color");
        String backgroundColorHex = Color.fromString(backgroundColor).asHex().toUpperCase();
        return backgroundColorHex;
    }

    public String addressTextGetText() {
        String addressTextString = addressTextButton.getText();
        return addressTextString;
    }

    public void addressTextButtonClick() {
        addressTextButton.click();

    }

    public void signInTextButtonClick() {
        signInTextButton.click();
    }

    public void shippingTextButtonClick() {
        shippingTextButton.click();

    }

    public String shippingTextButtonGetText(){
        String shippingTextButtonText = shippingTextButton.getText();
        return shippingTextButtonText;
    }

    public String shippingTextButtonReturnColor() {
        String backgroundColor = shippingTextButton.getCssValue("background-color");
        String backgroundColorHex = Color.fromString(backgroundColor).asHex().toUpperCase();
        return backgroundColorHex;
    }

}
