package Tutorial;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_Pages_Titles {
	
	private WebDriver driver;
	private String baseUrl;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty(
				"webdriver.gecko.driver", "C:/Users/devtest-pl/OneDrive - di-support/Eclipse/Projects/geckodriver/geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseUrl = "http://apptension.com/";
				
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void MainPageTitle() throws Exception {

		driver.get(baseUrl);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension Sp z o.o.";

		assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test
	public void AboutPageTitle() throws Exception {

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[1]/a")));
		
		driver.findElement(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[1]/a")).click();
		wait.until(ExpectedConditions.titleContains("_About"));
				
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension _About";
		
		assertEquals(ActualTitle, ExpectedTitle);
	} 
	
	@Test
	public void TeamPageTitle() throws Exception {

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[2]/a")));
		
		driver.findElement(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[2]/a")).click();
		wait.until(ExpectedConditions.titleContains("_Team"));
				
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension _Team";
		
		assertEquals(ActualTitle, ExpectedTitle);
	} 
	
	@Test
	public void WorkPageTitle() throws Exception {

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[3]/a")));
		
		driver.findElement(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[3]/a")).click();
		wait.until(ExpectedConditions.titleContains("_Portfolio"));
				
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension _Portfolio";
		
		assertEquals(ActualTitle, ExpectedTitle);
	} 
	
	@Test
	public void JobsPageTitle() throws Exception {

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[4]/a")));
		
		driver.findElement(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[4]/a")).click();
		wait.until(ExpectedConditions.titleContains("_Jobs"));
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension _Jobs";
		
		assertEquals(ActualTitle, ExpectedTitle);
	} 
	
	@Test
	public void BlogPageTitle() throws Exception {
		
		driver.get(baseUrl);
		driver.getWindowHandle();
								
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[5]/a")));
		
		WebElement link = driver.findElement(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[5]/a"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		wait.until(ExpectedConditions.titleContains("Blog"));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension Blog";
		
		assertEquals(ActualTitle, ExpectedTitle);
	} 
	
	@Test
	public void ContactPageTitle() throws Exception {

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[6]/a")));

		
		driver.findElement(By.xpath("html/body/div[2]/div/header/div[1]/nav/ul/li[6]/a")).click();
		wait.until(ExpectedConditions.titleContains("_Contact"));
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension _Contact";
		
		assertEquals(ActualTitle, ExpectedTitle);
	} 
	
}
		
		
