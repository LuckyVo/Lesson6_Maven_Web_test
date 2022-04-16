package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage extends AbstractPage{

    public CatalogPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = ".//a[@href='/catalog/pechenye/' " +
            "and @class='front_cont w_more_h']")
    private WebElement cookies;

    @FindBy(xpath = ".//a[@class='front_cont h_more_w' " +
            "and @style='background-image:url(/images/catalog/useful/10_image_small.jpeg); border-radius:0px']")
    private WebElement stock;

    public CatalogPage goToCookiesPage(){
        cookies.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("pechenye"));
        return this;
    }

    public CatalogPage goToStock(){
        stock.click();
        return this;
    }
}
