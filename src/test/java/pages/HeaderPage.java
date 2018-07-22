package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className ="login")
    private WebElement signInPageInHeader;



    public void signInPageInHeaderClick(){
        signInPageInHeader.click(); }
   // public HeaderPage (WebDriver driver) {
      //  this.driver = driver;
    //}

    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    private WebElement ContactUsButton;

    @FindBy(css = ".account > span:nth-child(1)")
    private WebElement myAccountButton;

    public WebElement getContactUsButton() {
        return ContactUsButton;
    }

    public void setMyAccountButtonClick() { myAccountButton.click();    }
}
