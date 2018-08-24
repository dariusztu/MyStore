package pages.cartPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartShippingPage {
    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?controller=order";

    public ShoppingCartShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#cgv")
    private WebElement termsOfServiceCheck;
    @FindBy(css="#order_step > li.step_current.four > span")
    private WebElement shippingTab;


    public WebElement acceptTermsOfServiceAtShippingTab() {
        this.termsOfServiceCheck.click();
        return this.termsOfServiceCheck;
    }


}
