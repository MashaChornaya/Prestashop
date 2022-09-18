# Prestashop_Masha_Chornaya

# Product Description:

Prestashop is a test site.

The theme of the site is an online women's clothing store.
Here you can register, select products,add them to the cart and proceed to checkout. In general, here you can perform all the actions that you can do in any online store, except that this is a test site and you can't really buy anything here.

Link : http://prestashop.qatestlab.com.ua/en/

This is how Prestashop home page looks like : 

![prestashop(homepage)](https://user-images.githubusercontent.com/105201355/190894043-5ec7c1fa-b52c-45b9-8264-1a0211c87498.png)

                         
# Prerequired installed components:
1) Java JDK 11.0.16 and Java JDK 18.0.1.1
2) Maven-3.8.6

#  Tools/ Liabraries/ Frameworks used:
1) Selenium 3.141.59
2) TestNG 7.6.0
3) Allure-testng 2.18.1
4) GitHub 5.2.0
5) Jenkins
6) Lombok 1.18.24
7) Log4j 2.18.0

This project was created with using the Page Object pattern.

# Setting up config
1) Clone this repository.


#  Checklist:
1) Verification for account creation: positive and negative scenario, using data provider.
2) Verification of the entrance to an already created account.
3) Verification to find products and their quantity: positive and negative scenario.
4) Checking the name, price and description of the product on the products page and item details page, using data provider.
5) Verification for adding, removing items from the cart.
6) Verification for the correctness of the actions performed on the address page.
7) Verify for checkout: positive and negative scenario.

#  Test Suites
Smoke tests:
Smoke tests suite includes tests: 
1) positiveCreateAccountTest, 
2) positiveSignInTest, 
3) negativeCreateAccountTest,
4) addItemToCartTest,
5) removeItemFromCartTest,
6) actionsForPositiveCheckoutTest.

Running the suite: mvn -DsuiteXmlFile=smokeTest.xml test

Regression tests:
Regression tests suite includes tests:
1) actionsOnAddressesPageTestWithSelect, 
2) inventoryItemsTestOnItemDetailsPage, 
3) inventoryItemsTestOnProductPage,
4) positiveSearchDressesTest,
5) negativeSearchItemTest.

Running the suite: mvn -DsuiteXmlFile=regressionTest.xml test

Negative tests:
Negative tests suite includes tests:
1) negativeCreateAccountTest, 
2) negativeSearchItemTest.
3) actionsForNegativeCheckoutTest.

Running the suite: mvn -DsuiteXmlFile=negativeTest.xml test


# Running all tests:
1) mvn clean test
2) mvn -DsuiteXmlFile=allTests.xml test

