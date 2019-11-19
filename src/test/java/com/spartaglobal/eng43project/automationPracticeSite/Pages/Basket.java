package com.spartaglobal.eng43project.automationPracticeSite.Pages;

import com.spartaglobal.eng43project.automationPracticeSite.Pages.Navigation.NavigationPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Basket {
    private WebDriver driver;
    private String basketUrl = "http://automationpractice.com/index.php?controller=order";

    private NavigationPages navigationPages;
    private By printedDressQuickBuy = By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span");
    private By proceedToCheckoutButton = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");


    public Basket(WebDriver driver) {
        this.driver = driver;
        navigationPages = new NavigationPages(driver);
    }

    public Basket goToBasketURL() {
        driver.navigate().to(basketUrl);
        return this;
    }

    public Basket goToHomePageURL(){
        navigationPages.homePage().goToHomePageURL();
        return this;
    }


    public Basket waitForElement(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public Basket addItemToBasket(){
        goToHomePageURL();
        driver.findElement(printedDressQuickBuy).click();
        return this;
    }

    public Basket proceedToCheckout(){
        addItemToBasket().waitForElement();
        driver.findElement(By.linkText("Proceed to checkout")).click();
        return this;
    }

}
