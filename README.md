#  Page Object Model Test Automation Framework using Selenium with Java,TestNG.

This project is for automating one full flow from adding product to cart till payment in the  website Amazon.com .
## Design pattern:Page Object Model using Selenium and TestNG concept
## Language:Java
## Approach:Hybrid
## IDE:Eclipse
All the jars needed to run the program is available in the lib .

### Test cases covered
1.Navigate to Amazon.com
2.Login to the website
3.Search for the product
4.Add the product to Card
5.Proceed to checkout
6.Proceed to  PaymentDetails
7.Enter Card Details and validate the Payment Failure when dummy values are entered.

## Selection of the Approach:
  POM is best suited for application which have multiple pages and hence best suited for Web applications.Each of which have fields which can be uniquely referenced with respect to page. and 
  We can easily add the further tests as the test progresses.
  
  Advantages:
  1.Object Repository(OR):We can create an OR of the fields segmented page wise.Each page will be defined as a java class.
  2.Encapsulation:We can define the data members and the all possible functionalities that can be performed on a page can be defined and contained within the same class created for each page.This provides clear definitin and scope of each page's functionality.
  3.Programmer friendly:The Object oriented approach makes the framework programmer friendly.
  4.Low Redundancy:Helps reduce code duplication.If architecture is correctly and sufficiently defined,POM gets more done in less code
  
  Disadvantages:
  1.High SetUp Time and Effort:Initial effort investment in development of Automation Framework is high.
  2.Testers shold be completely aware of the programming practice and have through knowledge of the architecture of the framework to implement correctly.
  3.Specific:This is not a generic model.This is specific to the application.

#### As I have followed  a Page Object Model , all pages will have a corresponding page.Java class and each page.java class has the test.java class
So as per the test case,I have  7 Page.java classes
(HomePage.java,LoginPage.java,ProductSearchPage.java,ProductResultPage.java,AddToCartPage.java,CheckoutPage.java,PaymentPage.java,CardDetailsPage.java)  and 
7 test.java classes(HomePageTest.java,LoginPageTest.java,ProductSearchPageTest.java,ProductResultPageTest.java,AddToCartPageTest.java,CheckoutPageTest.java,PaymentPageTest.java,CardDetailsPageTest.java)

#### So to have an organised way to keep the files,I have kept the source folders  src and testsrc

#### under src  I have  packages --- com.amazon.base,com.amazon.config,com.amazon.pages,com.amazon.testdata and com.amazon.util
#### under testsrc I have package ---- com.amazon.tests

### com.amazon.base is the package where i keep my base class which is inherited by all the other classes,so all the Page.java classes,test.java classes ,util.java class inherits this base class(TestBase.java)
### i have also used the data driven approach where i read the values from config.properties file and the Excel sheet
       The com.amazon.config package has the config.properties file from where i read the url,username,password,browser,productname
       The com.amazon.testdata package has the excel file from where the values for the payment card is read.
       #### For reading from excel you need Apache Poi.jar and I have used the Dataprovider to read this data from excel.
### com.amazon.util package has the TestUtil.java class which contains the common methods that can be used throughout the application.

### To run the test we can either use testNG.xml if we need to run as a testsuite when there are multiple methods in each tests.
Here I am running from Test.java class and for the final flow of the test case you can run from the last page defined which is CardDetailsPageTest.java
#### Right click on the test and run as TestNG test.

This framework architecture can be used to add more pages and functions as the test progresses.


       

    
