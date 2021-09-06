package org.example.lesson6;


import org.junit.jupiter.api.Test;


public class PageObjectTest extends BaseTest {

    @Test
    void loginInCrmWithPageObjTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjecSubMenu(driver).goToExpensesAllProjects();

        new AllProjects(driver).createExpense()
                .fillName("test")
                .company("v2007")
                .contact("Васильев Василий")
                .fillPriority("Средний")
                .fillFinanceSource("Внутреннее")
                .fillBusinessUnit("Research & Development")
                .fillCurator("Applanatest Applanatest Applanatest")
                .fillRp("Applanatest Applanatest Applanatest")
                .fillManagers("Юзеров Юзер")

                .saveAndCloseButton.click();
    }
}