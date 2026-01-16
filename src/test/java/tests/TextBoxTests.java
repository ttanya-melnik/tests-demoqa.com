package tests;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TextBoxTests {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически.

  }

  @Test
  void fillFormTest() {
    open("/text-box");
    $("#userName").setValue("Alex");
    $("#userEmail").setValue("alex@egorov.com");
    $("#currentAddress").setValue("Some street 1");
    $("#permanentAddress").setValue("Another street");
    $("#submit").click();

    $("#name").shouldHave(text("Alex"));
    $("#email").shouldHave(text("alex@egorov.com"));
    $("#output #currentAddress").shouldHave(text("Some street 1"));
    $("#output #permanentAddress").shouldHave(text("Another street"));
  }
}

