package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingWebsiteTestingProject {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginToFeisovet();
        driver.findElement(By.xpath("//li/a[text()='Новости']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(5000);
        driver.quit();

    }
    public static void loginToFeisovet() {
        driver.get("https://feisovet.ru/Логин");
        driver.findElement(By.name("login")).sendKeys("ivanivanov19732601");
        driver.findElement(By.name("pass")).sendKeys("2007Ivanov");
        driver.findElement(By.xpath("//button[contains(text(), ' Войти в аккаунт!')]")).click();
    }
}
