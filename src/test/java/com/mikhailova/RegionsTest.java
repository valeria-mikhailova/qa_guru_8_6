package com.mikhailova;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("eroshenkoam")
public class RegionsTest {

    @ParameterizedTest
    @ValueSource(strings = {"Москва", "Санкт-Петербург"})
    public void testGithub(String region) {
        parameter("Регион", region);

        step("Открываем главную страницу в регионе " + region, () -> {
            open("https://github.com");
            addAttachment("Hello", "World!");
        });
    }
}
