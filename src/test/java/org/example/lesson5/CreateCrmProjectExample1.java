package org.example.lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateCrmProjectExample1 {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCrm();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("test");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("v2007");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationVars.get(0).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_company')]/a")), "v2007"));
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Васильев Василий");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.findElement(By.name("crm_project[priority]")).sendKeys("Средний");
        driver.findElement(By.name("crm_project[financeSource]")).sendKeys("Внутреннее");
        driver.findElement(By.name("crm_project[businessUnit]")).sendKeys("Research & Development");
        driver.findElement(By.name("crm_project[curator]")).sendKeys("Applanatest Applanatest Applanatest");
        driver.findElement(By.name("crm_project[rp]")).sendKeys("Applanatest Applanatest Applanatest");
        driver.findElement(By.name("crm_project[manager]")).sendKeys("Юзеров Юзер");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        //Thread.sleep(5000);

        driver.switchTo().parentFrame();
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}