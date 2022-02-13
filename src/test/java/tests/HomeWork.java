package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWork {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() throws InterruptedException {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Momo");
        $("#lastName").setValue("Aang");
        $("#userEmail").setValue("Momo@avatar.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("89118885522");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1998");
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(byText("6")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Mountain");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Momo Aang"));
        $(".table-responsive").shouldHave(text("Momo@avatar.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8911888552"));
        $(".table-responsive").shouldHave(text("06 March,1998"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("picture.jpg"));
        $(".table-responsive").shouldHave(text("Mountain"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}

