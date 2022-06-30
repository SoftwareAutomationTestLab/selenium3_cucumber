package StepDefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Utilities.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
TestContextSetUp testsetup;
	
	public Hooks(TestContextSetUp testsetup1) {
		this.testsetup=testsetup1;}

@Before("@RegTest")
public void beforesceanrio() {
	System.out.println("Before Hooks ...");}

@After("@RegTest")
public void aftersceanrio() throws IOException,InterruptedException {
	System.out.println("After Hooks ...");
	testsetup.testbase.webmanager().quit();}

@AfterStep("@RegTest")
public void addscreenshots(Scenario scenario) throws IOException,InterruptedException {
	//Taking screenshots when Test Fail
	WebDriver driver=testsetup.testbase.driver;
	if(scenario.isFailed()) {
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                byte[] fileContent=FileUtils.readFileToByteArray(SrcFile);
                scenario.attach(fileContent, "image/png", "image");}
	
}}
  