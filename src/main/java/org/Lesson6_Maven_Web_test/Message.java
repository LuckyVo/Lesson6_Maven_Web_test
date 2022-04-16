package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Message extends AbstractPage{

    public Message(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = ".//div[@dir='ltr']")
    private WebElement message;

    @FindBy(xpath = ".//a[@data-b24-crm-button-widget='openline_livechat' " +
            "and @class='b24-widget-button-social-item b24-widget-button-openline_livechat']")
    private WebElement lineCRM;

    @FindBy(xpath = ".//textarea[@placeholder='Введите сообщение...' " +
            "and @class='bx-im-textarea-input']")
    private WebElement textarea;


    public void sendMessageToLineCRM(String text){
        message.click();
        new WebDriverWait(getDriver(),Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(lineCRM));
        lineCRM.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(textarea));
        textarea.click();
        textarea.clear();
        textarea.sendKeys(text + "\n");
    }


}
