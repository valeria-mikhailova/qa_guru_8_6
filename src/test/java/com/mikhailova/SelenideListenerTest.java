package com.mikhailova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideListenerTest {

    @Test
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").as("Поисковая строка").click();
        $(".header-search-input").as("Поисковая строка").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").as("Поисковая строка").submit();

        $(linkText("eroshenkoam/allure-example")).as("Ссылка репозитория").click();
        $(partialLinkText("Issues")).as("Таб Issues").click();
        $(byText("68")).as("Issue с номером 68").should(Condition.visible);
    }

}
