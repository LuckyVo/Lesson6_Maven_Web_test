package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritePage extends AbstractPage{

    public FavoritePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = ".//a[@href='/favorite/index.php/']")
    private WebElement likePage;

    public FavoritePage goFavoritePage(){
        likePage.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("favorite"));
        return this;
    }
}
