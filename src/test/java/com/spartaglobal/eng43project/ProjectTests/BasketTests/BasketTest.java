package com.spartaglobal.eng43project.ProjectTests.BasketTests;

import com.spartaglobal.eng43project.SeleniumConfig.SeleniumConfig;
import com.spartaglobal.eng43project.automationPracticeSite.AutomationPracticeSite;
import com.spartaglobal.eng43project.automationPracticeSite.Pages.Basket;
import io.cucumber.java.eo.Se;
import org.junit.*;

public class BasketTest {

    private static SeleniumConfig seleniumConfig;
    private static AutomationPracticeSite automationPracticeSite;

    @BeforeClass
    public static void setup(){
        // TODO: 18/11/2019 Change the driverPath to your own path!
        seleniumConfig = new SeleniumConfig("chrome","C:\\Users\\Edward James\\Downloads\\chromedriver_win32\\chromedriver.exe");

        automationPracticeSite = new AutomationPracticeSite(seleniumConfig.getDriver());
    }

//    @AfterClass
//    public static void teardown(){
//        seleniumConfig.getDriver().close();
//    }

    @Test
    public void checkUrlIsOpened(){
        automationPracticeSite.getBasket().goToBasketURL();
        automationPracticeSite.getBasket().addItemToBasket().goToBasketURL().proceedToCheckout();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=order",seleniumConfig.getDriver().getCurrentUrl());
    }

    @Test
    public void checkProceedToSummary(){
        automationPracticeSite.getBasket().addItemToBasket().proceedToCheckout();
    }

    @Test
    public void checkProceedToCheckout(){
        automationPracticeSite.getBasket().addItemToBasket().proceedToSummary().proceedToCheckout();
    }

    //#cart_quantity_up_3_13_0_237920
    //#cart_quantity_up_2_7_0_237920
    //#cart_quantity_up_3_13_0_237920 > span .checkTax()
}
