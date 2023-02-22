import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutCompletePage {

    private SelenideElement orderIsSucceededHeader = $x("//h2[@class='complete-header']");

    public CheckoutCompletePage checkOrderIsSucceededHeader(String headerText) {
        orderIsSucceededHeader.shouldHave(Condition.exactText(headerText));
        return this;
    }
}
