package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.*;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefinition {

	public RemoteWebDriver driver;

	@Given("^website is launched$")
	public void launchwebsite() {
		System.out.println("Given...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");}

	@When("^form is displayed$")
	public void loginform() {
		System.out.println("When...");}
	@And("enter valid credentials for {string} and {string}")
	public void enter_valid_credentials_for_and(String string1, String string2) {

		System.out.println("And...");
		System.out.println(string1);
		System.out.println(string2);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(string1);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(string2);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();} 
  
	@Then("^product page must be displayed")
	public void productpage() {
		System.out.println("Then...");}


	@And("^enter valid credentials for users$")
	public void enter_valid_credentials_for_users(io.cucumber.datatable.DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
		System.out.println("Data Tables");
		for(int i=0;i<rows.size();i++) {

			System.out.println(rows.get(i).get(0));
			System.out.println(rows.get(i).get(1));}}

	@And("^enter valid credentials for users with (.+) and (.+)$")
	public void enter_valid_credentials_for_users_with_locked_out_user_and_secret_sauce(String uname,String pwd) {
		System.out.println("Examples");
		System.out.println(uname); 
		System.out.println(pwd);}
	
	@Given("validate the browser")
	public void validate_the_browser() {
	  System.out.println("Background : given");}

	@When("browser is triggered")
	public void browser_is_triggered() {
		 System.out.println("Background : when");}

	@Then("check if the browser is started")
	public void check_if_the_browser_is_started() {
		System.out.println("Background : Then");}
}
