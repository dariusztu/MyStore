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

    @FindBy(css = ".cart_quantity_input")
    private WebElement productQuantityNumberInSummary;

    @FindBy(css = ".shopping_cart > a:nth-child(1)")
    private WebElement shoppingcartbutton;

    @FindBy(css = ".icon-minus")
    private WebElement substractbutton;

    @FindBy(css = ".icon-plus")
    private WebElement addbutton;

    @FindBy(css = ".icon-trash")
    private WebElement deleteButton;


    @FindBy(xpath = "//*[@id=\"step_end\"]/span")
    private WebElement inspectTextButton;


    public void inspectTextButtonClick() {
        inspectTextButton.click();

    }


    public WebElement checkIfdeleteButtonIsClickable() {
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
