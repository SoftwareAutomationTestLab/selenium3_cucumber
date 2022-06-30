package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class productspage {
public RemoteWebDriver driver;
	
	public productspage(RemoteWebDriver driver) {
		this.driver=driver;}
	
	
	By products=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	

	public String txt() {
		
		String txt1="";
		
		txt1=driver.findElement(products).getText();
		return txt1;}}
