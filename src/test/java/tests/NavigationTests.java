package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

public class NavigationTests extends TestBase{

    @Test
    void checkMainButtonsNavigationTest() {
        step("Click on Catalog button", () -> {
            $x("//android.view.View[@content-desc='Каталог']").click();
        });
        step("Verify presence of some categories", () -> {
            $$(className("android.widget.TextView"))
                    .findBy(text("Женщинам")).shouldBe(visible);
            $$(className("android.widget.TextView"))
                    .findBy(text("Мужчинам")).shouldBe(visible);
            $$(className("android.widget.TextView"))
                    .findBy(text("Детям")).shouldBe(visible);
        });
        step("Click on Cart button", () -> {
            $x("//android.view.View[@content-desc='Корзина']").click();
        });
        step("Verify Cart page header", () -> {
            $(id("com.wildberries.ru:id/tvTitle"))
                    .shouldHave(text("Ваша корзина пуста"));
        });
        step("Click on Profile button", () -> {
            $x("//android.view.View[@content-desc='Профиль']").click();
        });
        step("Verify Profile page header", () -> {
            $$(className("android.widget.TextView"))
                    .findBy(text("Войдите в свой профиль")).shouldBe(visible);
        });
        step("Click on Home button", () -> {
            $x("//android.view.View[@content-desc='Главная']").click();
        });
        step("Check presence of delivery city", () -> {
            $(id("com.wildberries.ru:id/addressChooser")).shouldBe(visible);
        });
    }
}
