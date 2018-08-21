package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement homePagecartButton;

    public WebElement getHomePagecartButtonClick() {
        this.homePagecartButton.click();
        return homePagecartButton;
    }


    public void goToHomePage(){
        driver.get("http://automationpractice.com/index.php");
    }
}
