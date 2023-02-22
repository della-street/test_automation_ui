import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutInformationPage {

    private SelenideElement firstNameField = $x("//input[@data-test='firstName']");
    private SelenideElement lastNameField = $x("//input[@data-test='lastName']");
    private SelenideElement zipPostalCodeField = $x("//input[@data-test='postalCode']");
    private SelenideElement continueButton = $x("//input[@data-test='continue']");
    private SelenideElement errorMessageFieldIsEmpty = $x("//h3[@data-test='error']");

    public CheckoutInformationPage inputFirstName(String firstName) {
        this.firstNameField.setValue(firstName);
        return this;
    }

    public CheckoutInformationPage inputLastName(String lastName) {
        this.lastNameField.setValue(lastName);
        return this;
    }

    public CheckoutInformationPage inputZipPostalCode(String zipPostalCode) {
        this.zipPostalCodeField.setValue(zipPostalCode);
        return this;
    }

    public CheckoutInformationPage clickContinueButton() {
        this.continueButton.click();
        return this;
    }

    public CheckoutOverviewPage checkCompleteOrderInformation(String firstName, String lastName, String zipPostalCode) {
        this.inputFirstName(firstName).
                inputLastName(lastName).
                inputZipPostalCode(zipPostalCode).
                clickContinueButton();
        return new CheckoutOverviewPage();
    }

    public CheckoutInformationPage checkCompleteOrderWithoutFirstName(String lastName, String zipPostalCode) {
        this.inputLastName(lastName).
                inputZipPostalCode(zipPostalCode).
                clickContinueButton();
        return new CheckoutInformationPage();
    }

    public CheckoutInformationPage checkErrorMessageFirstNameIsMissed(String errorFirstNameIsMissed) {
        errorMessageFieldIsEmpty.shouldHave(Condition.exactText(errorFirstNameIsMissed));
        return this;
    }

    public CheckoutInformationPage checkCompleteOrderWithoutLastName(String firstName, String zipPostalCode) {
        this.inputFirstName(firstName).
                inputZipPostalCode(zipPostalCode).
                clickContinueButton();
        return new CheckoutInformationPage();
    }

    public CheckoutInformationPage checkErrorMessageLastNameIsMissed(String errorLastNameIsMissed) {
        errorMessageFieldIsEmpty.shouldHave(Condition.exactText(errorLastNameIsMissed));
        return this;
    }

    public CheckoutInformationPage checkCompleteOrderWithoutZipPostalCode(String firstName, String lastName) {
        this.inputFirstName(firstName).
                inputLastName(lastName).
                clickContinueButton();
        return new CheckoutInformationPage();
    }

    public CheckoutInformationPage checkErrorMessageZipPostalIsMissed(String errorZipPostalCodeIsMissed) {
        errorMessageFieldIsEmpty.shouldHave(Condition.exactText(errorZipPostalCodeIsMissed));
        return this;
    }
}
