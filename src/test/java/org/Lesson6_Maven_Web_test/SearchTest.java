package org.Lesson6_Maven_Web_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends SiteInitialization{

    Logger logger = LoggerFactory.getLogger("Unit test's");

    @ParameterizedTest
    @CsvSource({ "Слойки","Вафли","Пироги"})
    @DisplayName("Тест-кейс: Поиск на сайте ")
    void testLike(String textForSearch) {
        try {
            new Search(getDriver()).goToSearchText(textForSearch);
            assertTrue(getDriver().findElement(By.xpath(".//input[@name='q' " +
                    " and @type='text' and @value='" + textForSearch + "']")).getAttribute("value").equals(textForSearch));
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
            logger.info(e.getMessage());
        }
        logger.info("Тест-кейс по поиску продукции на сайте пройден!");
    }

}
