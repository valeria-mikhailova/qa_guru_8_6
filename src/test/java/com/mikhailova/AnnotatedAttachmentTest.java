package com.mikhailova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotatedAttachmentTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            takeScreenshot();
            takePageSource();
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            takeScreenshot();
            takePageSource();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            takeScreenshot();
            takePageSource();
        });
        step("Открываем разедел Issues", () -> {
            $(partialLinkText("Issues")).click();
            takeScreenshot();
            takePageSource();
        });
        step("Проверяем наличие Issue с номером " + ISSUE_NUMBER, () -> {
            $(byText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }

    @Attachment(value = "Странице", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
