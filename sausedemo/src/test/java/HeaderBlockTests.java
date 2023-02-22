import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeaderBlockTests extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    @DisplayName("Проверка функционала логаута")
    void checkLogout() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        HeaderBlock headerBlock = new HeaderBlock();
        headerBlock.logOutOfAccount();
        authorizationPage.checkLogoutIsSuccessful();
    }

    @Test
    @DisplayName("Проверка возврата из корзины к полному списку товаров через выпадающий сайдбар")
    void checkReturningToAllItemsViaSidebar() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        HeaderBlock headerBlock = new HeaderBlock();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        headerBlock.chooseAllItemsInMenu().checkReturningToAllProductsPage("Products");
        productsPage.clickToCart();
        shoppingCartPage.removeProductFromCart();
    }
}
