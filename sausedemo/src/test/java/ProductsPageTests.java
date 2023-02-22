import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductsPageTests extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    @DisplayName("Отображение добавленных товаров в счетчике корзины")
    void checkAddToCartAllProductsPossibility() {
        /*
         * Проверка что добавленные товары отображаются в счетчике корзины
         * Нужно добавить все товары в корзину и проверить что счетчик корзины = 6
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.checkAddingAllProductToCart("6");
        productsPage.clickToCart();
        shoppingCartPage.removeProductFromCart();
    }

    @Test
    @DisplayName("Удаление добавленных товаров со страницы продуктов, исчезновение счетчика")
    void checkRemoveAllAddedProductsPossibility() {
        /*
         * Проверка что добавленные товары можно удалить на странице продуктов
         * Нужно удалить все товары на странице продуктов и проверить что счетчик корзины не отображается
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        ProductsPage productsPage = new ProductsPage();
        productsPage.addAllProductsToCart().checkProductCounterOnProductPageIsEmpty();
    }
}
