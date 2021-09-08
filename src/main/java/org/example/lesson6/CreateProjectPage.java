package org.example.lesson6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectName;

    public CreateProjectPage fillName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement companyName;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement projectCompanyName;

    public static final String projectCompanyObjectXpath ="//div[@class='select2-result-label']";

    @FindBy(xpath = projectCompanyObjectXpath)
    public WebElement projectCompanyObject;




    public CreateProjectPage company(String name) {
        companyName.click();
        projectCompanyName.sendKeys(name);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(projectCompanyObjectXpath)));
        projectCompanyObject.click();
        return this;
    }


    @FindBy(xpath = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")
    public WebElement projectCompanyObjectContactPerson;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement projectCompanyObjectContactPersonName;



    public CreateProjectPage contact(String name) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        projectCompanyObjectContactPerson.click();
        projectCompanyObjectContactPersonName.sendKeys(name);
        projectCompanyObjectContactPersonName.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(name = "crm_project[priority]")
    public WebElement companyPriority;

    public CreateProjectPage fillPriority(String name) {
        companyPriority.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_project[financeSource]")
    public WebElement companyFinanceSource;

    public CreateProjectPage fillFinanceSource(String name) {
        companyFinanceSource.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement companyBusinessUnit;

    public CreateProjectPage fillBusinessUnit(String name) {
        companyBusinessUnit.sendKeys(name);
        return this;
    }


    @FindBy(name = "crm_project[curator]")
    public WebElement companyCurator;

    public CreateProjectPage fillCurator(String name) {
        companyCurator.sendKeys(name);
        return this;
    }


    @FindBy(name ="crm_project[rp]")
    public WebElement expenseRequestRp;

    public CreateProjectPage fillRp(String name) {
        expenseRequestRp.sendKeys(name);
        return this;
    }

    @FindBy(name ="crm_project[manager]")
    public WebElement companyManager;

    public CreateProjectPage fillManagers(String name) {
        companyManager.sendKeys(name);
        return this;
    }






    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

}
