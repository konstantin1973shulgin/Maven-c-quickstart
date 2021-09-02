package org.example.lesson6;


import org.junit.jupiter.api.Test;


public class PageObjectTest extends BaseTest {

    @Test
    void loginInCrmWithPageObjTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ExpensesSubMenu(driver).goToExpensesAllProjects();

        new ExpensesAllProgects(driver)
                .createExpense()
                .fillName("test")
                /*.selectBusinessUnit("Укажите организацию")
               /* .selectExpenditure("v2007")
              /*  .selectCurrency("Доллар США")
                .fillSumPlan("1000")
                .selectDatePlan("20")
                .saveAndCloseButton.click()*/;

        Thread.sleep(10000);


    }
}