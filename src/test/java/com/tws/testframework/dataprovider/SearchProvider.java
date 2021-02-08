/**
 * #################### Test With A Smile ####################
 *                  Written by Andreas Popp
 *  For more informations visit https://test-with-a-smile.de
 *        or mailto andreas.popp@testautomation-popp.de
 * ###########################################################
 */

package com.tws.twsframework.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SearchProvider
{
    /**
     * The data provider will read the csv file search.csv in the folder test data and
     * create a dataprovider that contains the browser and all data from the csv file. This
     * way the test using the data provider will execute the test once for every row in the csv
     * file for every browser. With two rows and two browsers a test will be executed four times.
     * @return dataprovider The 2 demensional array for the data provider
     */
    @DataProvider (name = "search-data-provider")
    public Object[][] dpSearch(){

        // Create the variables for the browser, the csv data and the return value
        String [] browsers = BrowserProvider.browser();
        String [][] fileData = null;
        String [][] data;

        // Read the CSV content into a two demensional array
        String pathToCSVFile = "src/test/java/com/tws/testframework/testdata/search.csv";
        try (CSVReader reader = new CSVReader(new BufferedReader(new FileReader(pathToCSVFile)));) {
            List<String[]> lines = reader.readAll();
            fileData = lines.toArray(new String[lines.size()][]);
        }catch(Exception e){
            System.out.println("File not found.");
        }

        // Create the two demensional array for the return data
        data = new String[fileData.length * browsers.length][fileData[0].length + 1];

        // Merge the browsers and the data from the csv array in the result array
        int countResult = 0;
        for(int countBrowser = 0; countBrowser < browsers.length; countBrowser++){
            for (String[] csvRowData : fileData) {
                int countEntry = 1;
                for(String csvData : csvRowData){
                    data[countResult][countEntry] = csvData;
                    countEntry++;
                }
                data[countResult][0] = browsers[countBrowser];
                countResult++;
            }
        }

        return data;
    }
	
}