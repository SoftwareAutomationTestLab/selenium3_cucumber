package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PageObjectManager {
	
	RemoteWebDriver driver;
	LoginFormpage login;
	productspage productpage;
	
	
	public PageObjectManager(RemoteWebDriver driver) {
		this.driver=driver;}
	
	
	public LoginFormpage login(RemoteWebDriver driver) {
		return login=new LoginFormpage(driver);}
	
	public productspage productpage(RemoteWebDriver driver) {
		return productpage=new productspage(driver);}

}
