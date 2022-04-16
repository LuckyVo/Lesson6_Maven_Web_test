package org.Lesson6_Maven_Web_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationTest extends SiteInitialization{
    Logger logger = LoggerFactory.getLogger("Unit test's");

    @Test
    @DisplayName("Тест-кейс: Авторизация на сайте")
    void testAuthorizationIN(){
        try {
            new MainPage(getDriver()).goToAccountPage();
            assertTrue(getDriver().getTitle().equals("Войти"), "Страница не алё");
            new ToLoginPage(getDriver()).setLogin("v.kudraivzev@yandex.ru").setPassword("ASDFzxcv1234").loginIn();
            assertTrue(getDriver().findElement(By.xpath(".//a[@href='/personal/' " +
                    "and @class='lk_menu_h1']")).getText().equals("Личный кабинет"));
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e){
            logger.info(e.getMessage());
        }
        logger.info("Тест-кейс по авторизации пройден!");
    }

    @Test
    @DisplayName("Тест-кейс: Авторизация на сайте")
    void testAuthorizationINSecond(){
        try {
            new MainPage(getDriver()).goToAccountPage();
            assertTrue(getDriver().getTitle().equals("Войти"), "Страница не алё");
            new ToLoginPage(getDriver()).loginIn("v.kudraivzev@yandex.ru","ASDFzxcv1234");
            assertTrue(getDriver().findElement(By.xpath(".//a[@href='/personal/' " +
                    "and @class='lk_menu_h1']")).getText().equals("Личный кабинет"));
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e){
            logger.info(e.getMessage());
        }
        logger.info("Тест-кейс по авторизации пройден!");
    }



}
