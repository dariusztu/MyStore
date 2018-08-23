package pages.cartPage.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartSummaryPage {

        private String url = "http://automationpractice.com/index.php?controller=order";
    WebDriver driver;

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToPage() {
        driver.get(url);
    }

    //Summary

    @FindBy(css=".cart_quantity_input")
    private WebElement productQuantityNumberInSummary;

    @FindBy(css=".shopping_cart > a:nth-child(1)")
    private WebElement shoppingcartbutton;

    @FindBy(css=".icon-minus")
    private WebElement substractbutton;

    @FindBy(css=".icon-plus")
    private WebElement addbutton;

    @FindBy(css=".icon-trash")
    private WebElement deleteButton;



    @FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/ul/li[3]/span")
    private WebElement addressTextButton;

    @FindBy(xpath="//*[@id=\"order_step\"]/li[2]/span")
    private WebElement signInTextButton;

    @FindBy(xpath="//*[@id=\"order_step\"]/li[4]/span")
    private WebElement shippingTextButton;

    @FindBy(xpath="//*[@id=\"step_end\"]/span")
    private WebElement inspectTextButton;




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

    public void inspectTextButtonClick() {
        inspectTextButton.click();

    }



    public String addressTextButtonReturnColor() {
        String backgroundColor = addressTextButton.getCssValue("background-color");
        String backgroundColorHex = Color.fromString(backgroundColor).asHex().toUpperCase();
        return backgroundColorHex;
    }

    public WebElement checkIfdeleteButtonIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement returnButtonCSS;
        returnButtonCSS = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        return deleteButton;
    }

    public int checkProductQuantityInSummaryTab() {

        //int productQuantity = Integer.parseInt(this.productQuantityNumberInSummary.getAttribute("value"));
        int productQuantity = Integer.valueOf(this.productQuantityNumberInSummary.getAttribute("value"));
        return productQuantity;
    }

    public WebElement substractProductQuantityInSummaryTab() {
        this.substractbutton.click();
        return this.substractbutton;
    }

    public WebElement addProductQuantityInSummaryTab() {
        this.addbutton.click();
        return this.addbutton;
    }



}
