package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {
    WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className ="login")
    private WebElement signInPageInHeader;



    public void signInPageInHeaderClick(){
        signInPageInHeader.click();
    public HeaderPage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    private WebElement ContactUsButton;

    public WebElement getContactUsButton() {
        return ContactUsButton;
    }
}
