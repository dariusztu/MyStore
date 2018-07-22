package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

    WebDriver driver;

    public void MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#center_column > h1")
    WebElement myAccountTextOnPage;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    WebElement signOutButton;

    @FindBy(css = "#passwd")
    private WebElement passwordInPasswordFieldToLogIn;

    public String myAccountTextOnPageIsDisplayed() {
        String myAccount = myAccountTextOnPage.getText();
        return myAccount;
    }

    public void clickSignOutButton() {
        signOutButton.click();
    }


}




