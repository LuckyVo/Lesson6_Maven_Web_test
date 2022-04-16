package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NineNegrityatPage extends AbstractPage{

    public NineNegrityatPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = ".//button[@data-js='button-buy' " +
            "and contains(., 'В корзину')]")
    private WebElement toBasket;

    @FindBy(xpath = ".//a[@href='/basket/' " +
            "and contains(., 'К оформлению')]")
    private WebElement toTheDesign;


    public NineNegrityatPage toBasket(){
        toBasket.click();
        return this;
    }

    public NineNegrityatPage toMaking(){
        toTheDesign.click();
        return this;
    }
}
