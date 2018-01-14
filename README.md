# Budget
The tasks  is the following:

        1. Using ChromeDriver 2.34 together with Selenium Standalone Server 3.8.1., go to url test.estoreagency.ru
        
        2. Enter the site with login "test" and password "test123"
        
        3. Go to interface statistics and request results for the last 7 days (today included)
       
        4. Read the statistiques and create an xml with following format:
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
        Xml should contain the values for the last 7 days (today included)
        Save the XML in folder C:/results with naming "today"-"yourname".xml
        With today in format yyyy-mm-dd
        
        5. Upload XML to ftp account:
        login: testeStore
        password: eStoreAgency
        host: test.estoreagency.ru
