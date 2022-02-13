package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;

public class HomeWork {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest()  {
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
        $(".table-responsive").shouldHave(
                text("Student Name"), text("Momo Aang"),
                text("Student Email"), text("Momo@avatar.com"),
                text("Gender"), text("Male"),
                text("Mobile"), text("8911888552"),
                text("Date of Birth"), text("06 March,1998"),
                text("Subjects"), text("Biology"),
                text("Hobbies"), text("Reading"),
                text("Picture"), text("picture.jpg"),
                text("Address"), text("Mountain"),
                text("State and City"), text("NCR Delhi"));


    }
}

