package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends AbstractPage {

        @FindBy(xpath = ".//a[@href='/account/']")
        private WebElement account;

//        @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/abit/']/../ul/li")
//        private List<WebElement> subAbitList;

        @FindBy(xpath = ".//a[@href='/catalog/']")
        private WebElement catalog;


public MainPage(WebDriver driver) {
        super(driver);
        }

public MainPage goToAccountPage(){
        account.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("account"));
        return this;
        }

public MainPage goToCatalogPage(){
        catalog.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("catalog"));
        return this;
        }


//public void clickWelcome(){
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(abit).click(subAbitList.get(0)).build().perform();
//        }


}
