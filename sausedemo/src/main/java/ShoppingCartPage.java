import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ShoppingCartPage {

    private ElementsCollection listOfProductsInCart = $$x("//div[@class='inventory_item_name']");
    private ElementsCollection listOfRemoveButtonsInCart = $$x("//button[contains(@data-test,'remove')]");
    private SelenideElement productCounterInCart = $x("//span[@class='shopping_cart_badge']");
    private SelenideElement checkoutButton = $x("//button[@data-test='checkout']");

    public ShoppingCartPage amountOfProductsInCart(int amountOfProducts) {
        listOfProductsInCart.shouldHave(CollectionCondition.size(amountOfProducts));
        return this;
    }

    public ShoppingCartPage checkAmountOfProductsInCart(int amountOfProducts) {
        this.amountOfProductsInCart(amountOfProducts);
        return new ShoppingCartPage();
    }

    public ShoppingCartPage removeProductFromCart() {
        for (SelenideElement product : listOfRemoveButtonsInCart) {
            product.click();
        }
        return this;
    }

    public ShoppingCartPage checkProductCounterInCartNotVisible() {
        productCounterInCart.shouldNotBe(Condition.visible);
        return this;
    }

    public ShoppingCartPage checkProductCounterInCartIsEmpty() {
        this.removeProductFromCart().
                checkProductCounterInCartNotVisible();
        return new ShoppingCartPage();
    }

    public ShoppingCartPage clickCheckoutButton() {
        checkoutButton.click();
        return this;
    }
}
