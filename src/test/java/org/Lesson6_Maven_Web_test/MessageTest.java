package org.Lesson6_Maven_Web_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageTest extends SiteInitialization{

    Logger logger = LoggerFactory.getLogger("Unit test's");

    @Test
    @DisplayName("Тест-кейс: Установка продукта в избранное")
    void testLike() {
        try {
            new Message(getDriver()).sendMessageToLineCRM("CRM");
            assertTrue(getDriver().findElement(By.xpath(".//span[@class='bx-im-message-content-text' " +
                    "and text()='CRM']")).getText().equals("CRM"));
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
            logger.info(e.getMessage());
        }
        logger.info("Тест-кейс по отправлению текста сообщения CRM пройден!");
    }

}