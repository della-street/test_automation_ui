import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderBlock {

    private SelenideElement burgerMenu = $x("//button[@id='react-burger-menu-btn']");
    private SelenideElement logoutItemOfMenu = $x("//a[@id='logout_sidebar_link']");
    private SelenideElement allItemsInMenu = $x("//a[@id='inventory_sidebar_link']");

    public HeaderBlock clickBurgerMenu() {
        burgerMenu.click();
        return this;
    }

    public HeaderBlock clickLogoutItemOfMenu() {
        logoutItemOfMenu.click();
        return this;
    }

    public AuthorizationPage logOutOfAccount() {
        this.clickBurgerMenu().
                clickLogoutItemOfMenu();
        return new AuthorizationPage();
    }

    public HeaderBlock clickAllItemsInMenu() {
        allItemsInMenu.click();
        return this;
    }

    public ProductsPage chooseAllItemsInMenu() {
        this.clickBurgerMenu().
                clickAllItemsInMenu();
        return new ProductsPage();
    }
}
