package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.pages.RegistrationPage;

public class PracticeTestsForm {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = " Alexeev";
    String email = "emain@email.com";
    String gender = "Male";
    String mobile = "8002000500";
    String day = "25";
    String month = "June";
    String year = "1992";
    String subject = "Chemistry";
    String hobby = "Sports";
    String image = "photo.jpg";
    String address = "Current Address";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void automationPracticeTests() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setSubject(subject)
                .setHobby(hobby)
                .setImage(image)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setBirthDate(day, month, year);
        registrationPage.clickSubmit();
        registrationPage.checkModalForm();

        registrationPage
                .checkForm("Student Name", firstName + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", gender)
                .checkForm("Mobile", mobile)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobby)
                .checkForm("Picture", image)
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + city);

    }

}
