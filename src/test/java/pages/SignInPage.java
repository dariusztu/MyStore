package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends RegistrationForm{
    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath ="//*[@id=\"email_create\"]")
    private WebElement emailAdressField;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement submitButton;

    @FindBy(css = "#email")
    private WebElement emailInEmailFieldToLogIn;

    @FindBy(css = "#passwd")
    private WebElement passwordInPasswordFieldToLogIn;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private WebElement signInButton;





    public String setEmailForCreatingAccount(){
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        System.out.println("generated mail: "+ generatedString);
        String email = generatedString+"@mail.pl";
        emailAdressField.sendKeys(email);
        return email;
    }

    public void submitButtonClick(){
        submitButton.click();
    }

    public void enterMailinEmailField(String email){
        emailInEmailFieldToLogIn.sendKeys(email);
    }
    public void enterPasswordInPassworField (String password){
        passwordInPasswordFieldToLogIn.sendKeys(password);
    }
    public void clickSignInButton(){
        signInButton.click();
    }






}
