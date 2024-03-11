package com.score.pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import com.score.base.Helpers;

public class WelcomePage {

    private By getStartedBton;
    private static By pickfavLeague1;
    private static By pickfavLeague2;
    private By continueBton;
    private By welcomeHeader;
    static AndroidDriver driver;

  
   

    public WelcomePage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            getStartedBton = AppiumBy.id("com.fivemobile.thescore:id/action_button_text");
            continueBton = AppiumBy.id("com.fivemobile.thescore:id/action_button_text");
            welcomeHeader = AppiumBy.id("com.fivemobile.thescore:id/action_button_text");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
        	// Add IOS elements here
            
        }
    }
    
    public static void  selectLeagueTeams(String favLeague1, String favLeague2) {
    	
    	if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
    	pickfavLeague1 = AppiumBy.xpath("//android.widget.TextView[@text='"+favLeague1+"']");
    	pickfavLeague2 = AppiumBy.xpath("//android.widget.TextView[@text='"+favLeague2+"']");	
    	Helpers.click(pickfavLeague1);
    	Helpers.click(pickfavLeague2);
    	}else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
        	// Add IOS objects here
            
        }
    }
    
    public boolean validateLandingPage() {
    	Helpers.waitForEl(welcomeHeader);
    	return Helpers.isVisible(welcomeHeader);
    }
    
    public SearchPage getStarted(String favLeague1, String favLeague2) {
    	//Clicks Get Started button
    	Helpers.waitForEl(getStartedBton);
    	Helpers.click(getStartedBton);
    	selectLeagueTeams(favLeague1, favLeague2);
    	Helpers.click(continueBton);
    	//Clicks on Continue button
    	Helpers.waitForEl(continueBton);
    	Helpers.click(continueBton);
    	//Clicks on Done button
    	Helpers.waitForEl(continueBton);
    	Helpers.click(continueBton);
    	return new SearchPage();
    }

}
