package org.Lesson6_Maven_Web_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockTest extends SiteInitialization{

    Logger logger = LoggerFactory.getLogger("Unit test's");

    @Test
    @DisplayName("Тест-кейс: перейти на акции из каталога")
    void testGoToStockFromCatalog(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        try {
            new MainPage(getDriver()).goToCatalogPage();
            assertTrue(getDriver().getTitle().equals("Каталог продукции компании Хочу-Хочу"), "Страница не алё");
            jsExecutor.executeScript("window.scrollBy(0,700)");
            new CatalogPage(getDriver()).goToStock();
            WebElement head = getDriver().findElement(By.xpath(".//h1[@class='heading h1']"));
            String heading = head.getText();
            if (!heading.equals("Акции")) {
                logger.info("А страничка то не та, в каталоге(");
            } else {
                logger.info("Тест-кейс по переходу на акции из каталога пройден!");
            }
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
            logger.info(e.getMessage());
        }
    }

}
