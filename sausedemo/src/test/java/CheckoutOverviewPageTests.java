import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckoutOverviewPageTests extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String FIRST_NAME = "Irene";
    private static final String LAST_NAME = "Jackson";
    private static final String ZIP_POSTAL_CODE = "156789";

    @Test
    @DisplayName("Нажатие на кнопку Finish, появление заголовка об успехе")
    void checkFinishCheckoutPossibility() {
        /*
         * Проверка что есть возможность нажать на кнопку FINISH
         * Проверить что после нажатия на кнопку заголовок на странице CheckoutCompletePage = THANK YOU FOR YOUR ORDER
         * */
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        authorizationPage.successfulAuthorization(USERNAME, PASSWORD);
        productsPage.addAllProductsToCart().clickToCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutInformationPage.checkCompleteOrderInformation(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        checkoutOverviewPage.finishTheOrder();
        checkoutCompletePage.checkOrderIsSucceededHeader("THANK YOU FOR YOUR ORDER");
    }
}
