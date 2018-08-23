package pages.cartPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSignInPage {
    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?controller=order&step=1";

    public ShoppingCartSignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
