package tests;

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
        .setNumber("8900333111")
        .setDateOfBirth("28", "September", "2004")
        .setSubjects("English")
        .setHobbies()
        .UploadPicture(new File("src/DataTest/first.jpeg"))
        .setCurrentAddress("Some street 1")
        .setState("NCR")
        .setCity("Delhi")
        .clickSubmit()
        .checkModalContent()
        .shouldHaveModalTitle("Thanks for submitting the form")
        .checkResult("Student Name", "Tatiana Mel");

  }
}


