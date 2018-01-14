package test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BudgetListReader {
	
	public BudgetList readBudgetList(Date now, DateFormat dateFormat) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://test.estoreagency.ru");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_submit")));
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("_submit")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Statistics")));
        driver.findElement(By.linkText("Statistics")).click();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_MONTH, -6);
        
        driver.findElement(By.name("start_date")).clear();
        driver.findElement(By.name("end_date")).clear();
        
        driver.findElement(By.name("start_date")).sendKeys(dateFormat.format(cal.getTime()));
        driver.findElement(By.name("end_date")).sendKeys(dateFormat.format(now));
        
        driver.findElement(By.id("validate")).click();
        
        WebElement tbody = driver.findElement(By.tagName("table")).findElement(By.tagName("tbody"));
        
        List<WebElement> trList = tbody.findElements(By.tagName("tr"));
        
        BudgetList budgetList = new BudgetList();
        
        BudgetFormat budgetFormat = new BudgetFormat();
        
        for(WebElement tr : trList) {
        	List<WebElement> tdList = tr.findElements(By.tagName("td"));
        	
        	Budget budget = new Budget();

    		budget.setDate(budgetFormat.getDate(dateFormat, tdList.get(0).getText()));
    		budget.setImpression(budgetFormat.getDecimal(tdList.get(1).getText()));
    		budget.setVisits(budgetFormat.getDecimal(tdList.get(2).getText()));
    		budget.setCosts(budgetFormat.getCost(tdList.get(3).getText()));
    		
    		budgetList.add(budget);
        }
        
        driver.close();
        
        return budgetList;
	}
}
