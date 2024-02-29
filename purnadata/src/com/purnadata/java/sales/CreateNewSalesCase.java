package com.purnadata.java.sales;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewSalesCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Clicking on Sales
		driver.findElement(By.xpath("//span[contains(text(),'Sales')]")).click();

		// Selecting Sales Invoice from Sales Menu
		driver.findElement(By.xpath("//a[@href='sale_dashboard.php']")).click();

		// Clicking on New Sales Invoice Button
		driver.findElement(By.name("btn_new_party")).click();

		// Filling Invoice Details
		driver.findElement(By.id("invoice_no")).clear();
		driver.findElement(By.id("invoice_no")).sendKeys("101");

		driver.findElement(By.name("invoice_date")).clear();
		driver.findElement(By.name("invoice_date")).sendKeys("01/01/2024");

		driver.findElement(By.id("powo")).sendKeys("WO125");
		driver.findElement(By.id("powo_date")).sendKeys("05/01/2024");

		// Selection Bill To from dropdown
		WebElement selectBillTo = driver.findElement(By.id("bill_to"));
		Select dropdown = new Select(selectBillTo);
		dropdown.selectByVisibleText(" Krishna");

		driver.findElement(By.id("terms_cond")).sendKeys("NA");

		driver.findElement(By.id("sr_no")).clear();
		driver.findElement(By.id("sr_no")).sendKeys("11");
		driver.findElement(By.id("item_no")).sendKeys("65");
		driver.findElement(By.id("description")).sendKeys("Grocery");
		driver.findElement(By.id("hsn_code")).sendKeys("HSN1122");
		driver.findElement(By.id("unit")).sendKeys("1");
		driver.findElement(By.id("qty")).sendKeys("2");
		driver.findElement(By.id("rate")).sendKeys("500");

		driver.findElement(By.id("myButton")).click(); // Calculate Button

		// Selecting CGST, SGST, IGST from dropdowns
		WebElement selectCGST = driver.findElement(By.id("cgst"));
		WebElement selectSGST = driver.findElement(By.id("sgst"));
		WebElement selectIGST = driver.findElement(By.id("igst"));

		Select cgstDropdown = new Select(selectCGST);
		Select sgstDropdown = new Select(selectSGST);
		Select igstDropdown = new Select(selectIGST);

		cgstDropdown.selectByValue("6");
		sgstDropdown.selectByValue("9");
		igstDropdown.selectByValue("14");

		driver.findElement(By.id("transportation")).clear();
		driver.findElement(By.id("transportation")).sendKeys("2000");

		driver.findElement(By.id("packing_and_forwording")).clear();
		driver.findElement(By.id("packing_and_forwording")).sendKeys("1000");

		driver.findElement(By.id("myButtonlast")).click(); // GST Calculate Button

		// driver.findElement(By.id("btn_save_item")).click(); // Save Sale Item Button
		// driver.switchTo().alert().accept();

		driver.findElement(By.id("btn")).click(); // Save Button

		// Explicit wait for Alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		// Clicking Sale Invoice Details button to navigate on Sales Dasboard
		driver.findElement(By.xpath("//a[text()='Sale Invoice Details']")).click();

		// Validation
		if (driver.findElement(By.xpath("//td[text()='Krishna']")).isDisplayed())
			System.out.println("New sale invoice is generated successfully.!!");
		else
			System.out.println("Unexpected Result - New Sale invoice is not generated.");

		// Ending WebDriver session
		driver.quit();

	}

}
