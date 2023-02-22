import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationTests extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String WRONG_PASSWORD = "secret_sauce2";
    private static final String USERNAME_BLOCKED_USER = "locked_out_user";
    private static final String PASSWORD_BLOCKED_USER = "secret_sauce";

    @Test
    @DisplayName("Успешная авторизация")
    void checkSuccessLogin() {
        /*
         * Проверка успешной авторизации
         * После авторизации под пользователем standard_user проверить что на странице ProductPage размер списка товаров = 6
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.successfulAuthorizationCheck(6);
    }

    @Test
    @DisplayName("Неуспешная авторизация с несуществующим паролем")
    void checkFailedLoginWithInvalidPassword() {
        /*
         * Проверка неуспешной авторизации
         * Здесь два пути:
         * 1. Ввести несуществующие данные и попробовать авторизоваться
         * 2. Взять заблокированного пользователя и попробовать авторизоваться
         * В любом случае проверка заключается в том что в нотификации о неуспешной авторизации выводится соответствующий текст
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.unsuccessfulAuthorization(USERNAME, WRONG_PASSWORD);
        authorizationPage.unsuccessfulAuthorizationCheck("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @DisplayName("Неуспешная авторизация - юзер заблокирован")
    void checkFailedLoginOfBlockedUser() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.unsuccessfulAuthorization(USERNAME_BLOCKED_USER, PASSWORD_BLOCKED_USER);
        authorizationPage.unsuccessfulAuthorizationBlockedUserCheck("Epic sadface: Sorry, this user has been locked out.");
    }
}
