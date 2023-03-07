package StepDefinition;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Code;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CollectionsPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.Loggerload;
import utilities.ReadExcelNOTUSED;

public class Collections_step {
	 WebDriver driver;
	 String expectedmessage;
	//WebDriver driver=new FirefoxDriver();
	CollectionsPage collection=new CollectionsPage();
	String Excelpath = ConfigReader.getexcelfilepath();
	
	static String expectedMesg;
	
	//******************************  Main page  ***************************************	
	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() throws IOException {
		
		Loggerload.info("opening DS ALGO portal link"); 
		//driver.get(URl);
		collection.getPage();
	}
	
	@When("user clicks {string} button")
	public void user_clicks_button(String string) throws InterruptedException {
		collection.clickOngetStarted();
	}
	@Then("user should be redirected to the homepage and see {int} different collections")
	public void user_should_be_redirected_to_the_homepage_and_see_different_collections(Integer int1) {
	  String Page_Title=  collection.getPageTitle();
	  Loggerload.info("Page Title : "+Page_Title );
      assertEquals(Page_Title, "NumpyNinja", "Title do not match");
	}
	@Then("user click on the {string} dropdown arrow and sees {int} different collections")
	public void user_click_on_the_dropdown_arrow_and_sees_different_collections(String string, Integer int1) {
		collection.clickOndropDownDS();
	}
	@Then("user clicks any one collection from dropdown")
	public void user_clicks_any_one_collection_from_dropdown() {
		collection.clickOneFromDropDown();
	}
	@Then("user get alert message {string}")
	public void user_get_alert_message(String string) {
	   try{
		   String error_Message= collection.errorMessage();
		   Loggerload.info("Error Message : "+error_Message );
	   }
	   catch(NoSuchElementException e){
		   
	   }
		
	}
	@Then("user click on Data Structure {string} button")
	public void user_click_on_data_structure_button(String string) {
		try{Loggerload.info("user click on datastructure getstarted button");
		collection.clickondataStructureGetstarted();
	}catch(NoSuchElementException e){}
	}
	@When("user clicks {string} in homePage")
	public void user_clicks_in_home_page(String string) {
		try{collection.signIn();}
		catch(NoSuchElementException e) {}
	}
	@Then("user is redirected to Sign In page")
	public void user_is_redirected_to_sign_in_page() throws InvalidFormatException, IOException {
		String Page_Title=collection.getPageTitle();
		Loggerload.info("Page Title : "+Page_Title ); 
		assertEquals(Page_Title, "Login", "Title do not match");
		
	}

	//******************************  Login  ***************************************
	@Given("user launches login page")
	public void user_launches_login_page() throws IOException {
		Loggerload.info("User launches login page ");
		collection.LoginPage();
	}

	@When("user login using username and password from given {string} and {int}")
	public void user_login_using_username_and_password_from_given_and(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		Loggerload.info("User enter login credentials ");
		List<Map<String, String>> testData=reader.getData("src/test/resources/Exceldata/LoginDsAlgo.xlsx", 0);
		String User_name=testData.get(rowNumber).get("username");  // heading 
		String Pass_word=testData.get(rowNumber).get("password");  // heading 
		collection.loginWithCredentials(User_name, Pass_word);
		Loggerload.info("User redirected to login page ");
		String Title = collection.login_page();
		Loggerload.info("Title of current page is : " + Title);
		
	}	
	//******************************  Data Structure  ***************************************
	
	 // COMMON WHEN RUNNING INDIVIDUALLY FOR ARRAY, LINKED LIST , QUEUE, GRAPH , TREE, STACK 
	@Given("user login with username {string} and password {string}")
	public void user_login_with_username_and_password(String username, String password) throws IOException, InterruptedException {
		collection.LoginPage();
		collection.loginWithCredentials(username, password);
	}

	
	@Given("user launch datastructure page")
	public void user_launch_datastructure_page() throws IOException 
	{		
		collection.dataStructure();
	}
	
	@When("click on timecomplexity ,tryHere and tryEditor assessment page is open")
	public void click_on_timecomplexity_try_here_and_try_editor_assessment_page_is_open()
	{	
		collection.TryHere();
	}
	
	@Then("user enters code from {int} and {int} then click run , code is printed")
	public void user_enters_code_from_and_then_click_run_code_is_printed(Integer sheetNumber,Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
	{	
		collection.enterPythonCode(sheetNumber, rowNumber);
		expectedMesg=collection.getExpectedResult(sheetNumber, rowNumber);
		
		String actualSuccMessg = CollectionsPage.getActualResult();
		Loggerload.info("Actual result: "+actualSuccMessg );
		assertEquals(actualSuccMessg, expectedMesg," Results do not match");
	}
	
 	
	@Then("user navigate to homepage")
	public void user_navigate_to_homepage() throws IOException 
	{
		collection.backToHome();
	} 
	
	//******************************  Array  ***************************************
	
	
	
	@Given("user clicks {string}  in Array field")
	public void user_clicks_in_array_field(String string) throws IOException {
		
		collection.clickArray();
	}
	@When("user click {string} first link  in the Array list")
	public void user_click_first_link_in_the_array_list(String string) {
		collection.clickArraysInPython();
	}
	@Then("user clicks {string}")
	public void user_clicks(String string) {
		collection.clicktryHere();
	}
	@Then("user enters code in tryEditor from {string} and {int}  then click run , output is printed")
	public void user_enters_code_in_try_editor_from_sheet_number_and_then_click_run_output_is_printed(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		collection.enterPythonCode(sheetName, rowNumber);
		//expectedMesg=collection.getExpectedResult(sheetName, rowNumber);
		expectedMesg=collection.getExpectedResult(sheetName, rowNumber);
		String actualSuccMessg = CollectionsPage.getActualResult();
		Loggerload.info("Actual result: "+actualSuccMessg );
		assertEquals(actualSuccMessg, expectedMesg," Results do not match");
//		collection.CollectionscreenShot("Sample2.png");
	}
	
	@Given("user is in Array homepage")
	public void user_is_in_array_homepage() throws IOException {
		collection.clickArray();
	}
	@When("user click {string} second link  in the Array list")
	public void user_click_second_link_in_the_array_list(String string) {
		collection.clickArraysUsingList();
	}
	@When("user click {string} third link in the Array list")
	public void user_click_third_link_in_the_array_list(String string) {
		collection.clickBasicOperationinLists();
	}
	@When("user click {string} fourth link in the Array list")
	public void user_click_fourth_link_in_the_array_list(String string) {
		collection.clickApplicationsOfArray();
	}
//******************************&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	@When("user click practice question")
	public void user_click_practice_question() {
		collection.clickArraysInPython();
		collection.clickPracticeQuestions();
	}
	
	@Then("user clicks {string} in Practice questions 1")
	public void user_clicks_in_practice_questions_int(String string) {
		collection.clickSearchTheArray();
	}
	
	@Then("user clears the text")
	public void user_clears_the_text() {
		collection.clearCodeInTextEditorBox();
	}

	@When("user enters valid Python Code")
	//public void user_enters_valid_python_code(io.cucumber.datatable.DataTable dataTable) {	
	public void user_enters_valid_python_code(DataTable Pythoncode ) throws InvalidFormatException, IOException, InterruptedException {
		List<List<String>> data = Pythoncode.cells();
		collection.arrayPracticeQuestion(data.get(0).get(0));		
	}	
	
	@When("user clicks run button and captures output")
	public void user_clicks_run_button_and_captures_output() throws Exception {
//	   	String output = collection.getActualResult();
//		Loggerload.info("The output is:" + output);
		collection.clickRun();
//		collection.ScreenShot();
		String actualSuccMessg = CollectionsPage.getActualResult();
		Loggerload.info("Actual result: "+actualSuccMessg );
//		driver.navigate().back();
		collection.clickPracticeQuestionArray();
//		collection.clickSearchTheArray();
//		collection.clearCodeInTextEditorBox();
	}
	
	@When("user enters invalid Python Code")
	public void user_enters_invalid_python_code(DataTable Pythoncode) throws InvalidFormatException, IOException, InterruptedException {
		List<List<String>> data = Pythoncode.cells();
		collection.arrayPracticeQuestion(data.get(0).get(0));
	}

	@Then("user clicks run button and captures error message")
	public void user_clicks_run_button_and_captures_error_message() throws InterruptedException {
		collection.clickRun();
		String actualMsg = CollectionsPage.getErrorText();
		Loggerload.info("Error message for invalid python code is -" + actualMsg);
		Loggerload.info("Invalid code is taken  and clicked on run button");
		//assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
	}
	
	@When("user click on {string} in Practice questions 2")
	public void user_click_on_in_practice_questions_int(String string)  {
		collection.clickMaxConsecutiveOnes();	
		collection.clearCodeInTextEditorBox();
	}	
	
	@When("user enters Python Code {string}")
	public void user_enters_python_code(String code) throws InvalidFormatException, IOException, InterruptedException {
//	@When("user enters Python Code print\\(Max Consecutive Ones)")
//	public void user_enters_python_code_print_max_consecutive_ones(String code) throws InvalidFormatException, IOException {
		collection.arrayPracticeQuestion(code);		
	}

	@When("user clicks run button and captures output and error message if any")
	public void user_clicks_run_button_and_captures_output_and_error_message_if_any() throws InterruptedException, IOException {
//		String output = collection.getActualResult();
//		Loggerload.info("The output is:" + output);						
		try{
		Loggerload.info("User gets the error message in an Alert  ");
		String fetchError = collection.getErrorText();
		String ExpectedError="SyntaxError: bad input on line 1";
		Loggerload.info("Displayed Error Message  is "+fetchError);
		assertEquals(fetchError,ExpectedError,"Invalid Syntax error message");
		}
		catch(NoSuchElementException e){			   
		   }		
		//driver.navigate().back();
		collection.clickPracticeQuestionArray();
		//Loggerload.info("Invalid code is taken and clicked on run button");
		//assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
		} 
		
	@When("user click  {string} 3rd Practice questions")
	public void user_click_3rd_practice_questions(String string) {

			collection.clickfindNumbersWithEvenNumberOfDigits();	
			collection.clearCodeInTextEditorBox();					
		}
		

		@When("user click on {string}  Practice questions four")
		public void user_click_on_practice_questions_four(String string) {		  
			collection.squaresOfASortedArray();	
			collection.clearCodeInTextEditorBox();			
		}
		
		@When("user enters valid python Code {string} from config")
		public void user_enters_valid_python_code_from_config(String string) throws IOException, InterruptedException {
			collection.pythonCode(string );			  	
		}
		

     @Then("user enters invalid python Code {string} from config")
     public void user_enters_invalid_python_code_from_config(String string) throws IOException, InterruptedException {
	collection.errorCode(string);	
			  
		}
		
		
 	//*************************** Linked List *************************************
	
	@Given("user clicks {string}  in Linked List field")
	public void user_clicks_in_linked_list_field(String string) {
	    try {
			collection.clickLinkedList();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	@When("user click {string} first link  in the list")
	public void user_click_first_link_in_the_list(String string) {	   
		collection.clickIntroduction();		
	}
	@Given("user is in Linked List homepage")
	public void user_is_in_linked_list_homepage() throws IOException {
		collection.clickLinkedList();
	}
	@When("user click {string} second link  in the Linked list")
	public void user_click_second_link_in_the_linked_list(String string) throws InterruptedException {
	    collection.clickcreatingLinkedList();
	}
	@When("user click {string} third link in the Linked list")
	public void user_click_third_link_in_the_linked_list(String string) {
		collection.clickTypesofLinkedLists();
	}
	@When("user click {string} fourth link in the Linked list")
	public void user_click_fourth_link_in_the_linked_list(String string) {
	    collection.clickImplementLinkedListinPython();
	}
	@When("user click {string} fifth link in the Linked list")
	public void user_click_fifth_link_in_the_linked_list(String string) {
	   
	   collection.clickTraversal();
	}
	@When("user click {string} sixth link in the Linked list")
	public void user_click_sixth_link_in_the_linked_list(String string) {
		collection.clickInsertion();
	}
	@When("user click {string} seventh link in the Linked list")
	public void user_click_seventh_link_in_the_linked_list(String string) {
	    collection.clickDeletion();
	}
	//*************************** Stack *************************************

	@Given("user clicks {string}  in Stack field")
	public void user_clicks_in_stack_field(String string) throws InterruptedException {
	    try {
			collection.clickStack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("user click {string} first link  in the Stack")
	public void user_click_first_link_in_the_stack(String string) {
	   collection.clickOperationInStack();
	}
	@Given("user is in Stack homepage")
	public void user_is_in_stack_homepage() throws IOException, InterruptedException {
		collection.clickStack();
	}
	@When("user click {string} second link  in the Stack")
	public void user_click_second_link_in_the_stack(String string) {
	   collection.clickImplementation();
	}

	@When("user click {string} third link in the Stack")
	public void user_click_third_link_in_the_stack(String string) {
	   collection.clickApplications();
	}
	
	//*************************** Queue *************************************
	
	@Given("user clicks {string}  in Queue field")
	public void user_clicks_in_queue_field(String string) throws InterruptedException {
		try {
			collection.clickQueue();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@When("user click {string} first link  in the Queue")
	public void user_click_first_link_in_the_queue(String string) {
		collection.clickImplementationOfQueueInPython();
	}
	@Given("user is in Queue homepage")
	public void user_is_in_queue_homepage() throws IOException, InterruptedException {
		collection.clickQueue();
	}
	@When("user click {string} second link  in the Queue")
	public void user_click_second_link_in_the_queue(String string) {
		collection.clickImplementationUsingCollectionsDequeue();
	}
	@When("user click {string} third link in the Queue")
	public void user_click_third_link_in_the_queue(String string) {
		collection.clickImplementationUsingArray();
	}
	@When("user click {string} fourth link in the Queue")
	public void user_click_fourth_link_in_the_queue(String string) {
		collection.clickQueueOperations();
	}
	
	//*************************** Graph *************************************
	
	@Given("user login with username {string} and password {string} given through config")
	public void user_login_with_username_and_password_given_through_config(String string, String string2) throws InterruptedException, IOException {
		collection.LoginPage();
		collection.loginWithUernamePwd(string, string2);
		
	}
	
	@Given("user clicks {string}  in Graph field")
	public void user_clicks_in_graph_field(String string) throws IOException {	   
		collection.clickGraphLink();	  
	}
	
	@When("user click {string} first link  in the Graph")
	public void user_click_first_link_in_the_graph(String string) {
	    collection.clickGraph();
	}
	@Given("user is in Graph homepage")
	public void user_is_in_graph_homepage() throws IOException, InterruptedException {
		collection.clickGraphPage();
		
	}
	@When("user click {string} second link  in the Graph")
	public void user_click_second_link_in_the_graph(String string) {
		collection.clickGraphRepresentation();
	}
	
	//*************************** Tree *************************************
	
	@Given("user clicks {string}  in Tree field")
	public void user_clicks_in_tree_field(String string) throws InterruptedException {
	    try {
			collection.clickTree();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("user click {string} first link  in the Tree")
	public void user_click_first_link_in_the_tree(String string) {
		collection.clickOverviewOfTrees();
	}

	@Given("user is in Tree homepage")
	public void user_is_in_tree_homepage() throws IOException, InterruptedException {
		collection.clickTree();
	}
	@When("user click {string} 2nd link in the Tree")
	public void user_click_2nd_link_in_the_tree(String string) {
		collection.clickTerminologies();
	}
	@When("user click {string} 3rd link in the Tree")
	public void user_click_3rd_link_in_the_tree(String string) {
		collection.clickTypesOfTrees();
	}
	@When("user click {string} 4th link in the Tree")
	public void user_click_4th_link_in_the_tree(String string) {
		collection.clickTraversal();
	}
	@When("user click {string} 5th link in the Tree")
	public void user_click_5th_link_in_the_tree(String string) {
		collection.clickTraversalsIllustration();
	}
	@When("user click {string} 6th link in the Tree")
	public void user_click_6th_link_in_the_tree(String string) {
		collection.clickBinaryTrees();
	}

	@When("user click {string} 7th link in the Tree")
	public void user_click_7th_link_in_the_tree(String string) {
		collection.clickTypesOfBinaryTrees();
	}
	@When("user click {string} 8th link in the Tree")
	public void user_click_8th_link_in_the_tree(String string) {
		collection.clickImplementationInPython();
	}

	@When("user click {string} 9th link in the Tree")
	public void user_click_9th_link_in_the_tree(String string) {
		collection.clickBinaryTreeTraversals();
	}
	@When("user click {string} 10th link in the Tree")
	public void user_click_10th_link_in_the_tree(String string) {
		collection.clickImplementationOfBinaryTrees();
	}
	@When("user click {string} 11th link in the Tree")
	public void user_click_11th_link_in_the_tree(String string) {
		collection.clickApplicationOfBinaryTrees();
	}
	@When("user click {string} 12th link in the Tree")
	public void user_click_12th_link_in_the_tree(String string) {
		collection.clickBinarySearchTrees();
	}
	@When("user click {string} 13th link in the Tree")
	public void user_click_13th_link_in_the_tree(String string) {
		collection.clickImplementationOfBST();
	}

}
