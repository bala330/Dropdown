package org.in;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhpTravels {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phptravels.com/demo/");
		WebElement firstname = driver.findElement(By.xpath("//input[@name='first_name']"));
		firstname.sendKeys("mithnu");
		WebElement lastname = driver.findElement(By.name("last_name"));
		lastname.sendKeys("krishnan");
		WebElement businessname = driver.findElement(By.cssSelector("input[name='business_name']"));
		businessname.sendKeys("shopping mall");
		WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
		email.sendKeys("rajaqw22@gmail.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrolldown = driver.findElement(By.xpath("//label[contains(text(),'Email')]"));
		js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		WebElement num1 = driver.findElement(By.xpath("//span[@id='numb1']"));
		String s = num1.getText();
		System.out.println("sum of first number : " + s);
		int integ1 = Integer.parseInt(s);
		WebElement num2 = driver.findElement(By.xpath("//span[@id='numb2']"));
		String s1 = num2.getText();
		System.out.println("sum of second number : " + s1);
		int integ = Integer.parseInt(s1);
		WebElement sum = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		int sum1 = integ1 + integ;
		String add = Integer.toString(sum1);
		System.out.println("Adding the two numbers of sum : " + add);
		sum.sendKeys(add);
		WebElement submit = driver.findElement(By.xpath("//button[@id='demo']"));
		submit.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),' Thank you!')]")));
		WebElement text = driver.findElement(By.xpath("//strong[contains(text(),' Thank you!')]"));
		String sumbitext = text.getText();
		String Expectedtext = "Thank you!";
		if (sumbitext.equals(Expectedtext)) {
			System.out.println("It has successfully login");
		} else {
			System.out.println("It has not successfully login");

		}
		WebElement fullscreen = driver.findElement(By.xpath("//div[@class='border rounded-4 p-4 p-md-5']"));
		TakesScreenshot ts = ((TakesScreenshot) fullscreen);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./img.png");
		FileHandler.copy(src, dest);
		driver.quit();

	}

}
