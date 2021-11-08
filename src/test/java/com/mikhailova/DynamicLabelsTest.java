package com.mikhailova;

import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.feature;
import static io.qameta.allure.Allure.label;
import static io.qameta.allure.Allure.link;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.Allure.story;

public class DynamicLabelsTest {

    @Test
    @DisplayName("Проверка того, что мы можем поискать конкретную Issue")
    public void testGithub() {
        feature("Issue");
        story("Поиск по Issues");
        label("owner", "eroshenkoam");
        label("severity", SeverityLevel.BLOCKER.toString());
        link("Главная страница", "https://github.com");

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            addAttachment("Hello", "World!");
        });
    }
}
