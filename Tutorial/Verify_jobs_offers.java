package Tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;


public class Verify_jobs_offers {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty(
				"webdriver.gecko.driver",
				"C:/Users/devtest-pl/OneDrive - di-support/Eclipse/Projects/geckodriver/geckodriver.exe");

		driver = new FirefoxDriver();
		baseUrl = "http://apptension.com/jobs";

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void JobsPageTitle() throws Exception {

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.titleContains("_Jobs"));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Apptension _Jobs";

		assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test
	public void JobOffersButtonsClickableVerify() throws Exception {

		driver.get(baseUrl);
		Thread.sleep(2500);

		List<WebElement> btn_Submit = driver.findElements(By
				.className("main-menu-link"));
		System.out.println(btn_Submit);

		for (WebElement element : btn_Submit) {

			if (isClickable(element, driver)) {

				element.click();

			} else {

				System.out.println("Couldn't click: " + element);

			}
		}
	}

	public static boolean isClickable(WebElement el, WebDriver driver) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	@Test
	public void CheckExistingImages() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2500);

		List<WebElement> ImageFile = driver.findElements(By.tagName("img"));

		System.out.println(ImageFile);

		for (WebElement element : ImageFile) {
			boolean isLegal = (Boolean) ((JavascriptExecutor) driver)
					.executeScript(
							"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
							element);

			System.out.println(isLegal ? "Image displayed."
					: "Image is not displayed");

			assertTrue(isLegal);

		}
	}

	@Test
	public void CSSParameters() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2500);

		try {
			List<WebElement> elements = driver.findElements(By
					.className("main-menu-link"));
			System.out.println("number of elements: " + elements.size());

			for (WebElement element : elements) {

				System.out.println("------------------");
				System.out.println(element.getText());
				System.out.println("------------------");
				System.out.println(element.getAttribute("href"));
				System.out.println(element.getCssValue("font-size"));

				String Actual = element.getCssValue("font-size");
				String Expected = "12px";
				
				assertEquals(Actual, Expected);
			}
		}

		finally {

			driver.quit();
		}

	}
	
	
	}


