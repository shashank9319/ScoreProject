package com.score.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.score.base.Helpers;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SearchPage {
	
	 	private By searchBox;
	 	private By playerStats;
	 	private By dismissBton;
	 	private By searchText;
	 	private static By selectLeague;
	 	private By goBack;
	 	private static By tabDetails1;
	 	private static By tabDetails2;
	  
	    public SearchPage() {
	        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
	        	
	        	searchBox = AppiumBy.id("com.fivemobile.thescore:id/search_bar_text_view");
	        	playerStats = AppiumBy.xpath("//android.widget.TextView[@text='PLAYER STATS']");
	        	dismissBton = AppiumBy.id("com.fivemobile.thescore:id/dismiss_modal");
	        	searchText = AppiumBy.id("com.fivemobile.thescore:id/search_src_text");
	        	goBack = AppiumBy.accessibilityId("Navigate up");
	        	
	        	         		
	        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
	        	// Add IOS elements here
	            
	        }
	    }
	    
	    @AndroidFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
	    @iOSXCUITFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
	    private WebElement dismissPopup;
	    
	    public static boolean  selectTeam(String leagueTeam) {
	    	
	    	 if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
	    		 selectLeague = AppiumBy.xpath("//android.widget.TextView[@text='"+leagueTeam+"']");
	    		 Helpers.waitForEl(selectLeague);
	    		 Helpers.click(selectLeague);
	 	    	 return true;
	    	 } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
		        	// Add IOS objects here
		            
		        }
			return false;
	    	 }
	    
	    public static boolean  subTab(String insidetTabDetails1, String insidetTabDetails2) {
	    	
	    	 if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
	    		 tabDetails1 = AppiumBy.xpath("//android.widget.TextView[@text='"+insidetTabDetails1+"']");
	 	    	tabDetails2 = AppiumBy.xpath("//android.widget.TextView[@text='"+insidetTabDetails2+"']");
	 	    	Helpers.waitForEl(tabDetails1);
	 	    	Helpers.waitForEl(tabDetails2);
	 	    	 //validate after opening the sub tab
	 	    	Helpers.isVisible(tabDetails1);
	 	    	Helpers.isVisible(tabDetails2);
	 	    	 return true;
	    	 } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
		        	// Add IOS objects here
		            
		        }
			return false;
	    	 }
	    
	    public void searchLeague(String enterLeagueTeam) {
	    	// Clicks on X button
	    	Helpers.waitForEl(dismissBton);
	    	Helpers.click(dismissBton);
	    	// Clicks on Search box and enters data
	    	Helpers.waitForEl(searchBox);
	    	Helpers.click(searchBox);
	    	Helpers.waitNtype(searchText, enterLeagueTeam );
	    }
	    
	    public boolean selectLeagueTeam(String leagueTeam) {
	    	// Selects the team
	    	selectTeam(leagueTeam);
	    	//Assert after opening the league page
   		 	Helpers.isVisible(selectLeague);
	    	return true;
	    }
	    
	    public boolean clickSubTab(String insidetTabDetails1, String insidetTabDetails2) {
	    	Helpers.waitForEl(playerStats);
	    	Helpers.click(playerStats); 
	    	// Assert to validate the right sub tab
	    	subTab(insidetTabDetails1,insidetTabDetails2);
	    	return true;
	    }
	    
	   public boolean goBack() {
		   Helpers.waitForEl(goBack);
		   Helpers.click(goBack);
	    	//Assert to validate after clicking back button,whether returned to the previous page correctly
	    	return Helpers.isVisible(searchText);
	   }

}
