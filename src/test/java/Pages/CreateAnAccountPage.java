package Pages;

import com.mifmif.common.regex.Generex;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage {

    private WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/Marek/IdeaProjects/Junit/jdqzl1-selenium/src/test/java/chrome/chromedriver");
    }

    @FindBy(id = "email_create")
    WebElement emailAdress;

    public void setEmail(String email){
        String regex = "\\w{10}@gmail\\.com";
        emailAdress.sendKeys(new Generex(regex).random());;
    }


}
