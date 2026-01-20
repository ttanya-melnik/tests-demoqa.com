package tests;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PracticeFormTests {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически.

  }

  @Test
  void fillFormTest() {
    open("https://demoqa.com/automation-practice-form"); // открыли сайт
    $("#firstName").setValue("Tatiana"); // нашли по id, ввели значение
    $("#lastName").setValue("Mel"); // нашли по id, ввели значение
    $("#userEmail").setValue("tanya12345@gmail.com"); // нашли по id, ввели значение

    $("#genterWrapper").$(byText("Female")).click();
    // #genterWrapper- это контейнер с тремя радио кнопками. $(byText("Female")) - ищем внутри контейнера элемент с видимым текстом

    $("#userNumber").setValue("8900333111"); // нашли по id, ввели значение

    $("#dateOfBirthInput").click(); // открыли календарь
    $(".react-datepicker__month-select").selectOption("September"); // нашли по классу, установили месяц
    $(".react-datepicker__year-select").selectOption("2004"); // нашли по классу, установили год
    $(".react-datepicker__day--028").click(); // нашли по классу, установили день

    $("#subjectsInput").setValue("English").pressEnter(); // нашли по id, выбрали язык

    $("#hobbies-checkbox-2").parent().click();
    // parent - родительский элемент чекбокса, сам input type="checkbox" скрыт

    $("#uploadPicture").uploadFile(new File("src/DataTest/first.jpeg")); // загрузили файл
    $("#currentAddress").setValue("Some street 1");

    $("#state input").setValue("NCR").pressEnter(); // поле - выпадающий список, ввели текст, кликнули Enter
    $("#city input").setValue("Delhi").pressEnter(); // поле - выпадающий список, ввели текст, кликнули Enter

    $("#submit").click(); // кликнули на кнопку

  }
}
