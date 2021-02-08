/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.twsframework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResult {

    /*
	-------------------------------------------------------------------------
	Search Result for text
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.XPATH, using = "//*[@id='main']/header/h1")
	@CacheLookup
    public WebElement searchResultText;
    
    /*
	-------------------------------------------------------------------------
	Headline of the first result
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.XPATH, using = "//*[@id='post-wrapper']/article/div/header/h2/a")
	@CacheLookup
    public WebElement firstResultHeader;
    
    /*
	-------------------------------------------------------------------------
	Summary of the first result
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.XPATH, using = "//*[@id='post-wrapper']/article/div/div/p")
	@CacheLookup
    public WebElement firstResultSummary;
    
}