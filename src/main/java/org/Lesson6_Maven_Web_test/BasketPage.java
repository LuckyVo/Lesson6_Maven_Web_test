package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage extends AbstractPage{

    public BasketPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = ".//a[@href='/basket/' " +
            "and @class='button-ux main-ux solid checkout']")
    private WebElement basket;

    public BasketPage goToBasket(){
        basket.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("basket"));
        return this;
    }
}
