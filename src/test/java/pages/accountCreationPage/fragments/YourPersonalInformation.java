package pages.accountCreationPage.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourPersonalInformation {
    WebDriver driver;


    @FindBy(css = ".account_creation:nth-child(1) .clearfix")
    private WebElement title;
    //Title

    @FindBy(css = ".account_creation:nth-child(1) #firstname")
    private WebElement firstName;
    //    firstname
    @FindBy(css = ".account_creation:nth-child(1) #lastname")
    private WebElement lastName;
//    lastname

//    email
//password
//    date of birth
//    signup checkbox
//    receive checkbox


    public YourPersonalInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
