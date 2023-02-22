import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckoutInformationPageTests extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String FIRST_NAME = "Irene";
    private static final String LAST_NAME = "Jackson";
    private static final String ZIP_POSTAL_CODE = "156789";

    @Test
    @DisplayName("Заполнение формы, оформление заказа, проверка списка товаров")
    void checkCheckoutPossibility() {
        /*
         * Проверка что есть возможность заполнить форму и продолжить оформление заказа
         * Нужно заполнить поля формы и выполнить нажатие на кнопку continue
         * Проверить что на странице CheckoutOverviewPage размер списка товаров = 6 (в пререквизите добавьте все 6 товаров)
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutInformationPage.checkCompleteOrderInformation(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        checkoutOverviewPage.checkCheckoutListOfProduct(6);
        productsPage.clickToCart();
        shoppingCartPage.removeProductFromCart();
    }

    @Test
    @DisplayName("Ошибка при пустом поле FirstName")
    void checkErrorDueToBlankFirstNameInForm() {
        /*
         * Проверка что при пустом поле FirstName отдается соответствующая ошибка
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutInformationPage.checkCompleteOrderWithoutFirstName(LAST_NAME, ZIP_POSTAL_CODE).
                checkErrorMessageFirstNameIsMissed("Error: First Name is required");
        productsPage.clickToCart();
        shoppingCartPage.removeProductFromCart();
    }

    @Test
    @DisplayName("Ошибка при пустом поле LastName")
    void checkErrorDueToBlankLastNameInForm() {
        /*
         * Проверка что при пустом поле LastName отдается соответствующая ошибка
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutInformationPage.checkCompleteOrderWithoutLastName(FIRST_NAME, ZIP_POSTAL_CODE).
                checkErrorMessageLastNameIsMissed("Error: Last Name is required");
        productsPage.clickToCart();
        shoppingCartPage.removeProductFromCart();
    }

    @Test
    @DisplayName("Ошибка при пустом поле Zip/Postal Code")
    void checkErrorDueToBlankPostalCodeInForm() {
        /*
         * Проверка что при пустом поле PostalCode отдается соответствующая ошибка
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutInformationPage.checkCompleteOrderWithoutZipPostalCode(FIRST_NAME, LAST_NAME).
                checkErrorMessageZipPostalIsMissed("Error: Postal Code is required");
        productsPage.clickToCart();
        shoppingCartPage.removeProductFromCart();
    }
}
