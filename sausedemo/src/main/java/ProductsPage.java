import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    private ElementsCollection listOfProducts = $$x("//div[@class='inventory_item_name']");
    private ElementsCollection listOfAddButtons = $$x("//button[contains(@data-test,'add-to-cart')]");
    private ElementsCollection listOfRemoveButtons = $$x("//button[contains(@data-test,'remove')]");
    private SelenideElement productCounter = $x("//span[@class='shopping_cart_badge']");
    private SelenideElement cartIcon = $x("//a[@class='shopping_cart_link']");
    private SelenideElement allProductsListTitle = $x("//span[@class='title']");

    public ProductsPage successfulAuthorizationCheck(int amountOfProducts) {
        this.listOfProducts.shouldHave(CollectionCondition.size(amountOfProducts));
        return this;
    }

    public ProductsPage addAllProductsToCart() {
        for (SelenideElement product : listOfAddButtons) {
            product.click();
        }
        return this;
    }

    public ProductsPage checkAmountOfProductsInCart(String productAmount) {
        productCounter.shouldHave(Condition.text(productAmount));
        return this;
    }

    public ProductsPage checkAddingAllProductToCart(String productAmount) {
        this.addAllProductsToCart();
        checkAmountOfProductsInCart(productAmount);
        return new ProductsPage();
    }

    public ProductsPage removeAllProductsFromCartOnProductPage() {
        for (SelenideElement product : listOfRemoveButtons) {
            product.click();
        }
        return this;
    }

    public ProductsPage checkProductCounter() {
        productCounter.shouldNotBe(Condition.visible);
        return new ProductsPage();
    }

    public ProductsPage checkProductCounterOnProductPageIsEmpty() {
        this.removeAllProductsFromCartOnProductPage().
                checkProductCounter();
        return new ProductsPage();
    }

    public ShoppingCartPage clickToCart() {
        cartIcon.click();
        return new ShoppingCartPage();
    }

    public ProductsPage checkReturningToAllProductsPage(String title) {
        allProductsListTitle.shouldHave(Condition.exactText(title));
        return this;
    }
}
