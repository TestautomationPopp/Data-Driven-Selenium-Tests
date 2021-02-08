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

import org.testng.Assert;

public class TwsMain {

    /*
	-------------------------------------------------------------------------
	Logo on the main Website of test-with-a-smile
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.XPATH, using = "//*[@id='headimg']/a/img")
	@CacheLookup
    public WebElement logo;
    
    /*
	-------------------------------------------------------------------------
	Search field
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.XPATH, using = "//*[@id='search-2']/form/label/input")
	@CacheLookup
    public WebElement inp_search;
    
    /*
	-------------------------------------------------------------------------
	Search button
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.XPATH, using = "//*[@id='search-2']/form/button")
	@CacheLookup
    public WebElement btn_search;
    
    /*
	-------------------------------------------------------------------------
	Impressum Link
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.ID, using = "impressum")
	@CacheLookup
    public WebElement impressum;
    
    /*
	-------------------------------------------------------------------------
	Data protection Link
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.ID, using = "dataProtection")
	@CacheLookup
    public WebElement dataProtection;
    
    /*
	-------------------------------------------------------------------------
	About the author Link
	-------------------------------------------------------------------------
	*/
	@FindBy(how = How.ID, using = "about")
	@CacheLookup
    public WebElement aboutTheAuthor;

    public void checkFooter(){
        Assert.assertEquals("Impressum", impressum.getText());
        Assert.assertEquals("Data protection", dataProtection.getText());
        Assert.assertEquals("About the author", aboutTheAuthor.getText());
    }

    public void searchFor(String searchTerm){
        inp_search.sendKeys(searchTerm);
        btn_search.click();
    }
    
}