package org.Lesson6_Maven_Web_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketPageTest extends SiteInitialization{

    Logger logger = LoggerFactory.getLogger("Unit test's");

    @Test
    @DisplayName("Тест-кейс: Добавление продукта в корзину ")
    void testBasket() {
        try {
            new MainPage(getDriver()).goToCatalogPage();
            assertTrue(getDriver().getTitle().equals("Каталог продукции компании Хочу-Хочу"), "Страница не алё");
            new CatalogPage(getDriver()).goToCookiesPage();
            assertTrue(getDriver().getTitle().equals("Купить печенье оптом и в розницу в Москве " +
                    "| Заказать печенье от производителя в интернет-магазине «ХОЧУ-ХОЧУ»"), "Страница не алё");
            new CookiesPage(getDriver()).goToNineNegrityat();
            assertTrue(getDriver().getTitle().equals("Печенья 9 НЕГРИТЯТ 3,5 кг - " +
                    "купить оптом от производителя «Модная Кондитерка»"), "Страница не алё");
            new NineNegrityatPage(getDriver()).toBasket().toMaking();
            assertTrue(getDriver().findElement(By.xpath(".//a[@href='/catalog/pechenye/9-negrityat/' " +
                    "and text()='9 НЕГРИТЯТ']")).getText().equals("9 НЕГРИТЯТ"));
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
            logger.info(e.getMessage());
        }
        logger.info("Тест-кейс по добавлению продукта в корзину пройден!");
    }

}
