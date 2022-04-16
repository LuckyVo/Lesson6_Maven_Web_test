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

public class FavoriteTest extends SiteInitialization{

    Logger logger = LoggerFactory.getLogger("Unit test's");

    @Test
    @DisplayName("Тест-кейс: Установка продукта в избранное")
    void testLike() {
        try {
            new MainPage(getDriver()).goToCatalogPage();
            assertTrue(getDriver().getTitle().equals("Каталог продукции компании Хочу-Хочу"), "Страница не алё");
            new CatalogPage(getDriver()).goToCookiesPage();
            assertTrue(getDriver().getTitle().equals("Купить печенье оптом и в розницу в Москве " +
                    "| Заказать печенье от производителя в интернет-магазине «ХОЧУ-ХОЧУ»"), "Страница не алё");
            WebElement likeNineNegrityat = getDriver().findElement(By.xpath(".//div[@class='elem_wish ' " +
                    "and @data-id='24']"));
            likeNineNegrityat.click();
            new FavoritePage(getDriver()).goFavoritePage();
            assertTrue(getDriver().getTitle().equals("Избранное"), "Страница не алё");
            assertTrue(getDriver().findElement(By.xpath(".//a[@href='/catalog/pechenye/9-negrityat/' " +
                    "and text()='9 НЕГРИТЯТ']")).getText().equals("9 НЕГРИТЯТ"));
        } catch (NoSuchElementException | ElementNotInteractableException | StaleElementReferenceException e) {
            logger.info(e.getMessage());
        }
        logger.info("Тест-кейс по добавлению продукта в корзину пройден!");
    }

}

