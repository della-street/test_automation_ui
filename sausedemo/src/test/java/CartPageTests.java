import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartPageTests extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    @DisplayName("Отображение добавленных товаров в корзине")
    void checkGoodsAddedIsPresentInCart() {
        /*
         * Проверка что добавленные товары отображаются в корзине
         * Нужно добавить все товары в корзину и проверить что на странице корзины размер списка товаров = 6
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.checkAmountOfProductsInCart(6);
        shoppingCartPage.removeProductFromCart();
    }

    @Test
    @DisplayName("Удаление добавленных товаров из корзине, исчезновение счетчика")
    void checkDeleteGoodsFromCartPossibility() {
        /*
         * Проверка что есть возможность удалить добавленные товары из корзины
         * Удалить добавленные товары (пререквизит к тесту - товары должны быть добавлены в корзину) и проверить что счетчик в блоке
         * HeaderBlock не отображается
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.checkProductCounterInCartIsEmpty();
    }
}
