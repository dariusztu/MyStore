package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleProductPage {

    WebDriver driver;
    private String url = "http://automationpractice.com/index.php?id_product=2&controller=product";

    public SampleProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="button.exclusive")
    private WebElement addToCartButton;

    public void addToCartButtonClick() {
        addToCartButton.click();
    }

    public void goToPage() {
        driver.get(url);
    }




}
