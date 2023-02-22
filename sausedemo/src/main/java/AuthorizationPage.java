import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    private SelenideElement usernameField = $x("//input[@data-test='username']");
    private SelenideElement passwordField = $x("//input[@data-test='password']");
    private SelenideElement loginButton = $x("//input[@data-test='login-button']");
    private SelenideElement errorMessage = $x("//h3[@data-test='error']");
    private SelenideElement errorMessageBlockedUser = $x("//h3[@data-test='error']");

    public AuthorizationPage inputUsername(String username) {
        this.usernameField.setValue(username);
        return this;
    }

    public AuthorizationPage inputPassword(String password) {
        this.passwordField.setValue(password);
        return this;
    }

    public AuthorizationPage clickLoginButton() {
        this.loginButton.click();
        return this;
    }

    public ProductsPage successfulAuthorization(String username, String password) {
        this.inputUsername(username).
                inputPassword(password).
                clickLoginButton();
        return new ProductsPage();
    }

    public AuthorizationPage unsuccessfulAuthorizationCheck(String errorWrongPassword) {
        this.errorMessage.shouldHave(Condition.exactText(errorWrongPassword));
        return this;
    }

    public AuthorizationPage unsuccessfulAuthorization(String username, String password) {
        this.inputUsername(username).
                inputPassword(password).
                clickLoginButton();
        return new AuthorizationPage();
    }

    public AuthorizationPage unsuccessfulAuthorizationBlockedUserCheck(String errorBlockedUser) {
        this.errorMessageBlockedUser.shouldHave(Condition.exactText(errorBlockedUser));
        return this;
    }

    public AuthorizationPage checkLogoutIsSuccessful() {
        loginButton.shouldBe(Condition.visible);
        return this;
    }
}
