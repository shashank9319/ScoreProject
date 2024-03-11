package com.score.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.score.base.Util;
import com.score.basetest.BaseTest;
import com.score.pages.SearchPage;
import com.score.pages.WelcomePage;

public class WelcomePageTest extends BaseTest {
    
    WelcomePage welcomePage;
    SearchPage searchPage;
    String team = "TeamNames";
    String searchLeague = "SearchLeague";
    String selectLeague = "SelectLeague";
    String tableDetails = "TableName";
    
    @BeforeClass
    public void setup(){
    	welcomePage = new WelcomePage();
    	searchPage = new SearchPage();
    }
    
    @Severity(SeverityLevel.MINOR)
	@Description("Calidate welcome banner")
	@Feature("Test welcome banner")
    @Test(priority = 1)
    public void validateWelcomePage() {
    	Assert.assertTrue(welcomePage.validateLandingPage());
    }
    
	@DataProvider
	public Object[][] getTeamTestData(){
		Object data[][] = Util.getTestData(team);
		return data;
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Clicks on get started button and adds favourite teams")
	@Feature("Add favourite team to list")
    @Test(priority = 2, dataProvider="getTeamTestData")
    public void welcomePage(String team1,String team2){
    	welcomePage.getStarted(team1,team2);
    }
    
    @DataProvider
	public Object[][] getSearchLeagueData(){
		Object data[][] = Util.getTestData(searchLeague);
		return data;
	}
    
    @Severity(SeverityLevel.CRITICAL)
	@Description("Searches for teams using search bar")
	@Feature("Test the search bar")
    @Test(priority = 3, dataProvider = "getSearchLeagueData")
    public void searchPage(String searchLeagueName){
    	searchPage.searchLeague(searchLeagueName);
    }
    
    @DataProvider
  	public Object[][] SelectLeagueData(){
  		Object data[][] = Util.getTestData(selectLeague);
  		return data;
  	}
    
    @Severity(SeverityLevel.BLOCKER)
	@Description("After searching for the league name , clicks on it to open the team page")
	@Feature("Clicks on team name")
    @Test(priority = 4, dataProvider = "SelectLeagueData")
    public void selectTeam(String selectLeagueName) {
    	boolean flag = searchPage.selectLeagueTeam(selectLeagueName);
    	Assert.assertTrue(flag);
    }
    
    @DataProvider
  	public Object[][] tableData(){
  		Object data[][] = Util.getTestData(tableDetails);
  		return data;
  	}
    
    @Severity(SeverityLevel.NORMAL)
	@Description("Validates the table name for stats subtab")
	@Feature("Verify table names under stats tab")
    @Test(priority = 5, dataProvider = "tableData")
    public void subTab(String tableName1, String tableName2) {
    	boolean flag = searchPage.clickSubTab(tableName1, tableName2);
    	Assert.assertTrue(flag);
    }
    
    @Severity(SeverityLevel.MINOR)
   	@Description("Clicks on a back button and checks whether it returns to the previous page correctly")
   	@Feature("Testing back button")
    @Test(priority = 6)
    public void gobackToPreviousPage() {
    	boolean flag = searchPage.goBack();
    	Assert.assertTrue(flag);
    }
}
