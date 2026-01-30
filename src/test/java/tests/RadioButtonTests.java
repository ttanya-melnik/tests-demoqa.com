package tests;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RadioButtonTests {

  @BeforeAll
  static void beforeAll() { // void - не возвращает значения
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически
  }

  @Test
  void testRadioButton() {
    // открыть страницу
    open("/radio-button");

    // проверить заголовок
    $("h1").shouldHave(exactText("Radio Button")); // тег должен содержать только данный текст


    // проверяем, что ничего не выбрано
    $("#yesRadio").shouldNotBe(checked); // (атрибут checked должен быть у input), но не должен быть выбран
    $("#impressiveRadio").shouldNotBe(checked);
    $("#noRadio").shouldNotBe(checked);
    $(".text-success").shouldNotBe(visible); // ИЛИ $(".text-success").shouldBe(hidden); // элемент не должен быть виден


    // проверка клика на "Yes"
    $(byText("Yes")).click(); // ищем по тексту, делаем клик
    $("#yesRadio").shouldBe(checked); // должен появиться атрибут checked
    $("#impressiveRadio").shouldNotBe(checked); // другие две радио-кнопки не должны быть выбраны
    $("#noRadio").shouldNotBe(checked);

    // элемент должен быть виден, и должен содержать только данный текст
    $(".text-success").shouldBe(visible).shouldHave(exactText("Yes"));



    // Проверка клика на Impressive
    $("[for='impressiveRadio']").click(); // ищем по атрибуту, делаем клик
    $("#impressiveRadio").shouldBe(checked); // должен появиться атрибут checked
    $("#yesRadio").shouldNotBe(checked); // атрибут checked не должен появиться

    // элемент должен содержать только данный текст
    $(".text-success").shouldHave(exactText("Impressive"));



    // Проверка клика на "No" (не должна быть кликабельна)
    $("[for='noRadio']").click(); // ищем по атрибуту, делаем клик
    $("#noRadio").shouldNotBe(checked); // радио-кнопка не должна реагировать

  }
}
