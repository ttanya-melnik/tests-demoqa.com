package tests;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;   
import com.codeborne.selenide.Configuration;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически

  }

  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  void fillFormTest() {
    registrationPage.openPage();


    registrationPage.setFirstName("Tatiana")
        .setLastName("Mel")
        .setEmail("tanya12345@gmail.com")
        .setGender("Female")
        .setNumber("8900333111").setDateOfBirth("28", "September", "2004");

    $("#subjectsInput").setValue("English").pressEnter(); //

    $("#hobbies-checkbox-2").parent().click();


    $("#uploadPicture").uploadFile(new File("src/DataTest/first.jpeg")); // загрузили файл
    $("#currentAddress").setValue("Some street 1");

    $("#state input").setValue("NCR").pressEnter(); // поле - выпадающий список, ввели текст, кликнули Enter
    $("#city input").setValue("Delhi").pressEnter(); // поле - выпадающий список, ввели текст, кликнули Enter

    $("#submit").click(); // кликнули на кнопку


    $(".modal-content").should(appear); // должно появиться окно с заполненной формой
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // форма должна содержать данный текст
    registrationPage.checkResult("Student Name", "Tatiana Mel"); // проверить отображение текста в таблице

  }
}


