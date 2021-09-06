package org.example.lesson6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllProjects extends BaseView {
    public AllProjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createAllProjectsXpathLocator)
    public WebElement createExpenseButton;

    public CreateProjectPage createExpense() {
        createExpenseButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreateProjectPage(driver);
    }

    public static final String createAllProjectsXpathLocator = "//a[text()='Создать проект']";
}
