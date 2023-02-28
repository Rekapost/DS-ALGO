#USING DATA DRIVEN THROUGH EXCEL FILE  AND HARDCODED USERNAME AND PASSSOWRD
@array
Feature:  Array page
Scenario Outline: user navigate to array page and works on Arrays in Python
	Given user login with username "Numphysdet94NN" and password "sdet94batchNN"
	Given user clicks "Get started"  in Array field  
    When  user click "Arrays in Python" first link  in the Array list 
    Then  user clicks "Try here"   
    Then  user enters code in tryEditor from "<sheetName>" and <rownumber>  then click run , output is printed          
    Examples:  
	|sheetName      |rownumber|
	|pythonCode		|0 		  |
	|pythonCode	    |1        |
	
Scenario Outline: user does Arrays Using List	
	Given user is in Array homepage 
	When  user click "Arrays Using List" second link  in the Array list 
    Then  user clicks "Try here"   
    Then  user enters code in tryEditor from "<sheetName>" and <rownumber>  then click run , output is printed        
     Examples:  
	|sheetName      |rownumber|
	|pythonCode		|0 		  |
	|pythonCode	    |1        |
	
	Scenario Outline: user does Basic operations in Lists	
	Given user is in Array homepage 
	When  user click "Basic Operations in Lists" third link in the Array list 
    Then  user clicks "Try here"   
    Then  user enters code in tryEditor from "<sheetName>" and <rownumber>  then click run , output is printed    
     Examples:  
	|sheetName      |rownumber|
	|pythonCode		|0 		  |
	|pythonCode	    |1        |
	
	Scenario Outline: user does Applications of Array	
	Given user is in Array homepage 
	When  user click "Applications of Array" fourth link in the Array list
    Then  user clicks "Try here"   
    Then  user enters code in tryEditor from "<sheetName>" and <rownumber>  then click run , output is printed 
      
     Examples:  
	|sheetName      |rownumber|
	|pythonCode		|0 		  |
	|pythonCode	    |1        |
	
	Scenario: User navigates to practice question and practices
	 Given user is in Array homepage  
	 When user click practice question
	 Then user clicks "Search the array" in Practice questions 1
	 And  user clears the text  
	 When user enters valid Python Code 	  
	  |print("search the array")|
	 Then user clicks run button and captures output
	# When user enters invalid Python Code 	  
	# |print(| 
	# Then user clicks run button and captures error message
	# Then user navigate back 
	
	 Scenario Outline:  User validate Max Consecutive Ones page
    When user click on "Max Consecutive Ones" in Practice questions 2
    And user clears the text
    When user enters Python Code "<PythonCode>"
    And user clicks run button and captures output and error message if any
    Then user navigate to homepage     
    Examples:
     	|PythonCode|
        | print(Max Consecutive Ones)|
	 
	
	  