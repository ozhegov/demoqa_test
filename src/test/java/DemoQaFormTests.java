import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaFormTests {

    @BeforeAll
    static void configuration(){
        baseUrl = "https://demoqa.com";
        browserSize = "1920 x 1080";
        pageLoadStrategy = "eager";
    }

    @Test
    void checkPracticeFormTest(){

      open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
      $("#firstName").setValue("John");
      $("#lastName").setValue("Malkovich");
      $("#userEmail").setValue("j.malk@test.com");
      $("#genterWrapper").$(byText("Male")).click();
      $("#userNumber").setValue("8888888888");
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption("May");
      $(".react-datepicker__year-select").selectOption("1990");
      $(".react-datepicker__day--002").click();
      $("#subjectsContainer").click();
      $("#subjectsInput").setValue("Maths").pressEnter();
      $("#hobbiesWrapper").$(byText("Sports")).click();
      $("#uploadPicture").uploadFromClasspath("ava.jpg");
      $("#currentAddress").setValue("Los Angeles, 92 Groove st 9B");
      $("#state").click();
      $("#stateCity-wrapper").$(byText("NCR")).click();
      $("#city").click();
      $("#stateCity-wrapper").$(byText("Delhi")).click();
      $("#submit").click();

      $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
      $(".table-responsive").shouldHave(
              text("John Malkovich"),
              text("j.malk@test.com"),
              text("Male"),
              text("8888888888"),
              text("02 May,1990"),
              text("Maths"),
              text("Sports"),
              text("ava.jpg"),
              text("Los Angeles, 92 Groove st 9B"),
              text("NCR Delhi")
      );

      holdBrowserOpen = true;
    }
}
