package org.example.lesson6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjecSubMenu extends BaseView {
    public ProjecSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement allProjectsMenuitem;

    public void goToExpensesAllProjects() {
        allProjectsMenuitem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(AllProjects.createAllProjectsXpathLocator)));
    }
}