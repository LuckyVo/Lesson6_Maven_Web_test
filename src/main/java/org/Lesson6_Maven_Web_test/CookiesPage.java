package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesPage extends AbstractPage{

    public CookiesPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = ".//a[@href='/catalog/pechenye/9-negrityat/']")
    private WebElement nineNegrityat;

    public CookiesPage goToNineNegrityat(){
        nineNegrityat.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("pechenye"));
        return this;
    }
}
