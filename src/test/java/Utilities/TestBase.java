package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public RemoteWebDriver driver;

	public RemoteWebDriver webmanager() throws IOException,InterruptedException{

		
		FileInputStream fis=new FileInputStream("src/test/resources/Global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String browsername=	prop.getProperty("browser");
		String url=prop.getProperty("testurl");
		System.out.println("From Test Base");
		System.out.println(browsername);
		System.out.println(url);
		
		
		if(driver==null ) {

       if(browsername.equalsIgnoreCase("chrome")){
		/*WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();*/
		ChromeOptions chromeoptions=new ChromeOptions();
		chromeoptions.setHeadless(true);
		driver=new RemoteWebDriver(new URL("http://hub:4444/wd/hub"),chromeoptions);}
     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
		System.out.println("Test Base after opening website:"+driver.getCurrentUrl());
		
	}
		return driver;
	}}
