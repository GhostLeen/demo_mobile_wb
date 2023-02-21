package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.*;

@Owner("a.denyushina")
@Epic("Mobile app wildberries")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Сurrency change on main page")
    void currencyChangeTest() {
        step("Click on currency change button", () -> {
            $(id("com.wildberries.ru:id/savedCurrencyButtonIndicatorView"))
                    .click();
        });
        step("Chose Kazakhstan's currency", () -> {
            $(accessibilityId("Казахский тенге")).click();
        });
        step("Сheck that selected currency displays on the main screen", () -> {
            $(id("com.wildberries.ru:id/savedCurrencyNameView"))
                    .shouldHave(text("\uD83C\uDDF0\uD83C\uDDFF тг."));
        });
    }

    @Test
    @DisplayName("Search field test")
    void searchFromMainPageTest() {
        step("Enter a value in the search field", () -> {
            $(id("com.wildberries.ru:id/search_searchEditText")).click();
            $x("//android.widget.EditText").sendKeys("antistress");
            $x("//android.widget.EditText").click();
        });
        step("Verify search results", () -> {
            $$(className("android.widget.TextView"))
                    .findBy(text("antistress toy")).shouldBe(visible);
        });
    }
}
