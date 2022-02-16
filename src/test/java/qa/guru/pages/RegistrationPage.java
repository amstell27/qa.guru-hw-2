package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import qa.guru.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    //locators
    public static SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderInput = $("#genterWrapper"),
            emailInput = $("#userEmail"),
            mobileInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            resultsTable = $(".table-responsive"),
            hobbyInput = $("#hobbiesWrapper"),
            imageInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            modalTitle = $(".modal-header");


    //actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setMethodValue(SelenideElement locator, String param) {

        locator.setValue(param);
        return this;

    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public void setBirthDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

    }

    public RegistrationPage setSubject(String subject) {

        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {

        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setImage(String image) {

        imageInput.uploadFromClasspath(image);
        return this;
    }

    public RegistrationPage setState(String state) {

        stateInput.click();
        $(new ByText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {

        cityInput.click();
        $(new ByText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {

        submit.click();
        return this;
    }

    public RegistrationPage checkModalForm() {

        modalTitle.shouldBe(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }
}
