package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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




}
