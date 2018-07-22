package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#center_column > h1")
    WebElement myAccountTextOnPage;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    WebElement signOutButton;

    @FindBy(css = "#passwd")
    private WebElement passwordInPasswordFieldToLogIn;

    @FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[3]/a/span")
    private WebElement myAddressesButton;

    public String myAccountTextOnPageIsDisplayed() {
        String myAccount = myAccountTextOnPage.getText();
        return myAccount;
    }

    public void myAddressesButtonClick() {
        myAddressesButton.click();
    }

    public void clickSignOutButton() {
        signOutButton.click();
    }


}




