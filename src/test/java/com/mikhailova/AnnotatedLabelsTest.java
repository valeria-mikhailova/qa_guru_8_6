package com.mikhailova;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class AnnotatedLabelsTest {

    @Test
    @Feature("Issue")
    @Owner("eroshenkoam")
    @Story("Поиск по Issues")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка того, что мы можем поискать конкретную Issue")
    @Severity(SeverityLevel.BLOCKER)
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            addAttachment("Hello", "World!");
        });
    }

}
