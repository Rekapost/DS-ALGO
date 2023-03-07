#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@arrayPractice
Feature: DS Algo ArrayPractice Page

  @arrayPractice
   Scenario: User navigate to Array Practice Page and works in Search the array
   Given user login with username "Numphysdet94NN" and password "sdet94batchNN" given through config
   Given user clicks "Get started"  in Array field 
   When User is in Array Practice homepage 
   When User clicks "Search the array" first link in the Array Practice list
   And  user clears the text and enter python code 
   Then user enters Python Code "print(\"Hello\");" from config 
   
  Scenario: User navigate to Array Practice Page and works in Max Consecutive Ones
   #Given user login with username "Numphysdet94NN" and password "sdet94batchNN" given through config
   Given user clicks "Get started"  in Array field 
   When User is in Array Practice homepage 
   When User clicks "Max Consecutive Ones" second link in the Array Practice list
   And  user clears the text and enter python code 
   Then user enters Python Code1 "print(Hello);" from config 
   Then user gets the error message
  
  Scenario: User navigate to Array Practice Page and works in Find Numbers with Even Number of Digits
   #Given user login with username "Numphysdet94NN" and password "sdet94batchNN" given through config
   Given user clicks "Get started"  in Array field 
   When User is in Array Practice homepage 
   When User clicks "Find Numbers with Even Number of Digits" third link in the Array Practice list
   And  user clears the text and enter python code 
   Then user enters python code
         | print("Find Numbers with Even Number of Digits")|
   
   Scenario: User navigate to Array Practice Page and works in Squares of  a Sorted Array
   #Given user login with username "Numphysdet94NN" and password "sdet94batchNN" given through config
   Given user clicks "Get started"  in Array field 
   When User is in Array Practice homepage 
   When User clicks "Squares of  a Sorted Array" fourth link in the Array Practice list
   And  user clears the text and enter python code 
   Then user enters python code
         | Squares of  a Sorted Array       |
         | print(Squares of  a Sorted Array)|
   Then user gets the error message
 