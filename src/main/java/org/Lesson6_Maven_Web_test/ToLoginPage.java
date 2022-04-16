package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToLoginPage extends AbstractPage {

    public ToLoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement userPassword;

    @FindBy(xpath = ".//a[@href='javascript:void(0)' and @class='button']")
    private WebElement submit;

    public void loginIn(){
        this.submit.click();
    }

    public ToLoginPage setLogin(String login){
        this.userName.click();
        this.userName.clear();
        this.userName.sendKeys(login);
        return this;
    }

    public ToLoginPage setPassword(String password){
        this.userPassword.click();
        this.userPassword.clear();
        this.userPassword.sendKeys(password);
        return this;
    }

    public ToLoginPage setLogIn (){
        this.submit.click();
        return this;
    }

    public void loginIn(String login, String password){
        Actions loginIn = new Actions(getDriver());
        loginIn
                .click(this.userName)
                .sendKeys(this.userName,login)
                .click(this.userPassword)
                .sendKeys(password)
                .click(this.submit)
                .build()
                .perform();
    }




}
