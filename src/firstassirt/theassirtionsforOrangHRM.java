package firstassirt;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class theassirtionsforOrangHRM {
	String expectedLogin = "Login";
	String expectedButtun = "submit";
	String userName = "Admin";
	String Passwoard = "admin123";
	String expectedtheloginiftru = "Dashboard";
	String expectedtheinvaledloginiftru = "Invalid credentials";
	String expectedEmpty = "Required";
	String expectedForget = "Forgot your password?";
	String expectedResetPassword = "Reset Password";
	String expectedLogout = "Login";
	String expectedOrang = "OrangeHRM OS 5.5";

	WebDriver driver = new ChromeDriver();
	SoftAssert myAssertion = new SoftAssert();

	@BeforeTest
	public void MyBeforeTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void Login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String ActualLogin = driver.findElement(By.className("orangehrm-login-title")).getText();
		myAssertion.assertEquals(ActualLogin, expectedLogin, "Login not found");

	}

	@Test()
	public void myTest2() {
		boolean contains = driver.findElement(By.className("oxd-input--active")).getAttribute("class")
				.contains("active");
		myAssertion.assertEquals(contains, true);

	}

	@Test()
	public void myTest3() {
		WebElement loginButtun = driver.findElement(By.className("oxd-button"));
		myAssertion.assertTrue(loginButtun.isDisplayed(), "Username input field is not displayed on the login page.");
	}
//    @Test()
//    public void myTest4() {
//    	driver.findElement(By.name("username")).sendKeys(userName);
//    	driver.findElement(By.name("password")).sendKeys(Passwoard);
//    	driver.findElement(By.className("orangehrm-login-button")).click();
//    	String tocheckthelogin = driver.findElement(By.className("oxd-topbar-header-breadcrumb-module")).getText();
//    	myAssertion.assertEquals(tocheckthelogin, expectedtheloginiftru);        
//    }
//    
//    @Test()
//    public void myTest5() {
//    	driver.findElement(By.name("username")).sendKeys("hello");
//    	driver.findElement(By.name("password")).sendKeys("1235hello");
//    	driver.findElement(By.className("orangehrm-login-button")).click();
//    	String tochecktheinvalidlogin = driver.findElement(By.className("oxd-alert-content-text")).getText();
//    	myAssertion.assertEquals(tochecktheinvalidlogin, expectedtheinvaledloginiftru);        
//    }
//   
//    @Test
//    public void myTest6() {
//    	
//    	driver.findElement(By.className("orangehrm-login-button")).click();
//    	String EmptyLogin = driver.findElement(By.className("oxd-input-field-error-message")).getText();
//    	myAssertion.assertEquals(EmptyLogin, expectedEmpty);
//    
//    }
//    @Test
//    public void myTest7() {
//    	
//     	String ForgetPassward = driver.findElement(By.className("orangehrm-login-forgot")).getText();
//    	myAssertion.assertEquals(ForgetPassward, expectedForget);
//    
//    }

//    @Test
//    public void myTest8() {
//    	
//     	driver.findElement(By.className("orangehrm-login-forgot")).click();
//     	String checkTheForget= driver.findElement(By.className("orangehrm-forgot-password-title")).getText();
//    	myAssertion.assertEquals(checkTheForget, expectedResetPassword);
//    
//    }

//    @Test()
//    public void myTest9() {
//    	driver.findElement(By.name("username")).sendKeys(userName);
//    	driver.findElement(By.name("password")).sendKeys(Passwoard);
//    	driver.findElement(By.className("orangehrm-login-button")).click();
//    	driver.findElement(By.className("bi-caret-down-fill")).click();
//    	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
//    	String tocheckthelogout = driver.findElement(By.className("orangehrm-login-title")).getText();
//    	myAssertion.assertEquals(tocheckthelogout, expectedLogout); 
//    }

//	@Test
//	public void myTest10() {
//
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		String checkthePage = driver.findElement(By.className("orangehrm-copyright")).getText();
//		myAssertion.assertEquals(checkthePage, expectedOrang);
//
//	}

	@Test()
	public void myTest11() throws InterruptedException {
		for (int i = 0; i < 3; i++) {

			Random number = new Random();
			int randomNumber = number.nextInt(100) + 1;
			String RandomPassword = "admin" + randomNumber;

			driver.findElement(By.name("username")).sendKeys("your_username");
			driver.findElement(By.name("password")).sendKeys(RandomPassword);
			driver.findElement(By.className("orangehrm-login-button")).click();
			
			String tochecktheinvalidlogin = driver.findElement(By.className("oxd-alert-content-text")).getText();
			myAssertion.assertEquals(tochecktheinvalidlogin, expectedtheinvaledloginiftru);
			
			Thread.sleep(2000);
		}
	}

	@AfterTest
	public void myAfterTest() {
		myAssertion.assertAll();

	}

}
