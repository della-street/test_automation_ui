import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {

    private ElementsCollection listOfProductsOnCheckoutOverviewPage = $$x("//div[@class='inventory_item_name']");
    private SelenideElement finishButton = $x("//button[@data-test='finish']");

    public CheckoutOverviewPage checkCheckoutListOfProduct(int checkoutAmountOfProducts) {
        listOfProductsOnCheckoutOverviewPage.shouldHave(CollectionCondition.size(checkoutAmountOfProducts));
        return this;
    }

    public CheckoutOverviewPage clickFinishButton() {
        finishButton.click();
        return this;
    }

    public CheckoutCompletePage finishTheOrder() {
        clickFinishButton();
        return new CheckoutCompletePage();
    }
}
