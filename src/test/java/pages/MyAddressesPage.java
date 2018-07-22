package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressesPage {

    private String url = "http://automationpractice.com/index.php?controller=addresses";

    WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="/html/body/div/div[2]/div/div[3]/div/div[2]/a/span");
    private WebElement addNewAddressButton;

    public void addNewAddressButtonClick() {
        addNewAddressButton.click();
    }

}
