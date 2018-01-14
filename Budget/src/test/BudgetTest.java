/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Emilien Roux
 */
public class BudgetTest {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println("Opening browser. Reading budget list");
        
    	BudgetList budgetList = new BudgetListReader().readBudgetList(now, dateFormat);
        
        System.out.println("Parsing budget list to xml");
    	
        String xml = new BudgetXmlParser().getXml(budgetList);
        
        ReportFileWritter manager = new ReportFileWritter();
        
        File reportsDir = new File("C:\\reports\\");
        String reportFileName = dateFormat.format(now) + "-Vardan.xml";
        
        manager.write(xml, reportsDir, reportFileName);
        
        System.out.println("Report file is saved.");
        
        System.out.println("Uploading report file.");
       
        new ReportFileUploader().upload(new File(reportsDir, reportFileName));
        
        System.out.println("Report file is uploaded.");
        
        // Go to url test.estoreagency.ru
        
        // Enter the login "test", password "test123" and validate with button OK
        
        // Go to interface statistics and request results for the last 7 days  (today included)
       
        // Read the statistiques and create an xml with following format:
        /*
         * <budgets>
         *  <budget>
         *      <date>2016-07-01</date>
         *      <visits>2129</visits>
         *      <impression>10645</impression>
         *      <costs>111.98</costs>
         *  </budget>
         *  ...
         * </budgets>
         */
        // Xml should contain the values for the last 7 days (today included)
        // Save the XML in folder C:/results with naming "today"-"yourname".xml
        // With today in format yyyy-mm-dd
        
        // Upload XML to ftp account:
        // login: testeStore
        // password: eStoreAgency
        // host: test.estoreagency.ru
        
        // It is now the end !
    } 
}
