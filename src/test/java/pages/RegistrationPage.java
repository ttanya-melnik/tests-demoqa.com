package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

public class RegistrationPage { // класс — Page Object


  public static SelenideElement firstNameInput =$("#firstName");

  public static SelenideElement lastNameInput =$("#lastName");

  public static SelenideElement userEmailInput =$("tanya12345@gmail.com");

  public static SelenideElement genderWrapper =$("#genterWrapper");

  public static SelenideElement userNumberInput =$("#userNumber");

  public static SelenideElement calendarInput =$("#dateOfBirthInput");

  CalendarComponent calendarComponent = new CalendarComponent();

  public RegistrationPage openPage() {
    open("/automation-practice-form"); // открыли страницу
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); // нашли по тексту
    return this;
  }


  public RegistrationPage setFirstName(String value) { // set - бизнес-язык
    firstNameInput.setValue(value);
    return this;
  }

  public RegistrationPage setLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  public RegistrationPage setEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public RegistrationPage setGender(String value) {
    genderWrapper.$(byText(value))
        .click();
    return this;

  }


  public RegistrationPage setNumber(String value) {
    userNumberInput.setValue(value);
    return this;  // данный метод не ведет на другую страницу, код становится более читаемым
  }


  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public RegistrationPage checkResult(String key, String value) {
    $(".table-responsive").$(byText(key)).shouldHave(text(value));

    return this;
  }
}





