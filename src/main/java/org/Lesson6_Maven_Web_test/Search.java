package org.Lesson6_Maven_Web_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends AbstractPage{

    public Search(WebDriver driver){super(driver);}

    @FindBy(xpath = ".//button[@class='button-ux magnifier default search' " +
            " and @data-js='button-search']")
    private WebElement search;

    @FindBy(xpath = ".//input[@class='input' " +
            "and @name='q']")
    private WebElement textArea;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement submit;

    public void goToSearchText(String text){
        Actions searchText = new Actions(getDriver());
        searchText
                .click(this.search)
                .click(this.textArea)

                .sendKeys(text)
                .click(this.submit)
                .build()
                .perform();
    }
}
//        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(input));
