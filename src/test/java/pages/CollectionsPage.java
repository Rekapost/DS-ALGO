package pages;
import java.io.FileInputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import crossBrowser.driverFactory;
import utilities.ConfigReader;
import utilities.ElementsUtils;
import utilities.Loggerload;

public class CollectionsPage {
	public static WebDriver driver=driverFactory.getdriver();
	
	
	private final static String propertyFilePath = "./src/test/resources/config.properties";
  //******************************  Main Page  ***************************************
	By getStarted=By.xpath("//a[@href='/home']");
	@FindBy (xpath="//a[contains(text(),'Data Structures')]")WebElement dropDown;
	@FindBy (linkText ="Stack")WebElement dropDown_stack;
	@FindBy (linkText ="Sign in")WebElement sign_In;
	@FindBy (xpath="//a[contains(@href,'data-structures-introduction')]")WebElement dataStructureDropDown;
	By registerBut=By.linkText("Register");
	//alert 	
	@FindBy (xpath="//*[@class='alert alert-primary']")
	static WebElement alert_msg;
  //******************************  Login  ***************************************
    By login_Username=By.name("username");
    By login_Password=By.name("password");;
    By login_Button=By.xpath("//input[@value='Login']");    
  //******************************  DataStructure  ***************************************
    private static Properties properties;
    static ElementsUtils eleUtil = new ElementsUtils();
    String DataStructureURL="https://dsportalapp.herokuapp.com/data-structures-introduction/";
    //By getStartedDS=By.xpath("//a[@href='data-structures-introduction']");
	String tryEditorURL=ConfigReader.tryEditorURL();	   
	By getTimeComplexity=By.xpath("//a[contains(text(),'Time Complexity')]");
	By tryhere=By.xpath("//a[contains(text(),'Try here>>>')]");
	@FindBy (xpath="//textarea[@tabindex='0']")WebElement editorInput;
	//By editorInput=By.xpath("//textarea[@tabindex='0']");
	//@FindBy (xpath="//textarea[contains(@id,'editor')]")WebElement editorInput;
	By enterPythonText=By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	//By whiteBox=By.xpath("//span[@class='cm-builtin']");
	By runButton=By.xpath("//button[contains(text(),'Run')]");
//	By runBtn=By.xpath("//form[@id='answer_form']//button");
	By pythonOutPut=By.id("output");
	
  //******************************  Array  ***************************************	
	@FindBy (xpath="//a[contains(@href,'array')]")WebElement arrayLink;
	@FindBy (xpath="//body/div[2]/ul[1]")WebElement arraysInPython;
	@FindBy (xpath="//body/div[2]/div/div[2]/a")WebElement tryHere;
	@FindBy (xpath="//a[contains(text(),'Arrays Using List')]")WebElement arraysUsingList;
	@FindBy (xpath="//a[contains(text(),'Basic Operations in Lists')]")WebElement arraysBasicOperationinList;
	@FindBy (xpath="//a[contains(text(),'Applications of Array')]")WebElement arraysApplicationofArray;	
	@FindBy (xpath="//a[contains(text(),'Practice Questions')]")WebElement practiceQuestionsinArray;	
	@FindBy (xpath="//a[contains(text(),'Search the array')]")WebElement SearchTheAarray;	
	@FindBy (xpath="/html/body/div[3]/a")WebElement maxConsecutiveOnes;
	//@FindBy (xpath="//a[contains(text(),'Practice Questions')]")WebElement inputBox;
	@FindBy (xpath="//button[contains(text(),'Run')]")WebElement runButtoninPracticeQuestions;
	//pre[@id='output']
	@FindBy (xpath="//textarea[@id='editor']")WebElement enterPythontextArea;
	
	  @FindBy(xpath="//a[contains(text(),'Find Numbers with Even Number of Digits')]")WebElement findNumbersWithEvenNumberOfDigits;
      @FindBy(xpath="//body/div[5]/a") WebElement squaresOfASortedArray;
      
      //******************************** Linked List *****************************************
	@FindBy (xpath="//a[contains(@href,'linked-list')]")WebElement LinkedListLink;
	@FindBy (xpath="//a[contains(text(),'Introduction')]")WebElement introduction;
	@FindBy (xpath="//a[contains(text(),'Creating Linked LIst')]")WebElement creatingLinkedList;
	@FindBy (xpath="//a[contains(text(),'Types of Linked List')]")WebElement typesOfLinkedList;
	@FindBy (xpath="//a[contains(text(),'Implement Linked List in Python')]")WebElement implementLinkedList;
	@FindBy (xpath="//a[contains(text(),'Traversal')]")WebElement traversal;
	@FindBy (xpath="//a[contains(text(),'Insertion')]")WebElement insertion;
	@FindBy (xpath="//a[contains(text(),'Deletion')]")WebElement deletion;
   //******************************** Stack *****************************************
	@FindBy (xpath="//a[contains(@href,'stack')]")WebElement StackLink;
	@FindBy (xpath="//a[contains(text(),'Operations in Stack')]")WebElement operationsInStack;
	@FindBy (xpath="//a[contains(text(),'Implementation')]")WebElement implementation;
	@FindBy (xpath="//a[contains(text(),'Applications')]")WebElement applications;
   //******************************** Queue *****************************************
	@FindBy (xpath="//a[contains(@href,'queue')]")WebElement QueueLink;
	@FindBy (xpath="//a[contains(text(),'Implementation of Queue in Python')]")WebElement implementationUsingCollectionsDequeue;
	@FindBy (xpath="//a[contains(text(),'Implementation using collections.deque')]")WebElement implementationOfQueueInPython;
	@FindBy (xpath="//a[contains(text(),'Implementation using array')]")WebElement implementationUsingArray;
	@FindBy (xpath="//a[contains(text(),'Queue Operations')]")WebElement queueOperations;	
   //******************************** Graph *****************************************
	@FindBy (xpath="//a[@href='graph']")WebElement graphLink;
	@FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Graph']")WebElement graph;
	@FindBy (xpath="//a[contains(text(),'Graph Representations')]")WebElement graphRepresentations ;
   //******************************** Tree *****************************************
	@FindBy (xpath="//a[@href='tree']")WebElement treeLink;
	@FindBy (xpath="//a[contains(text(),'Overview of Trees')]")WebElement overviewOfTrees;
	@FindBy (xpath="//a[contains(text(),'Terminologies')]")WebElement terminologies ;
	@FindBy (xpath="//a[contains(text(),'Types of Trees')]")WebElement typesOfTrees;
	@FindBy (xpath="//a[contains(text(),'Tree Traversals')]")WebElement treeTraversal ;
	@FindBy (xpath="//a[contains(text(),'Traversals-Illustration')]")WebElement traversalsIllustration;
	@FindBy (xpath="//a[contains(text(),'Binary Trees')]")WebElement binaryTrees ;
	@FindBy (xpath="//a[contains(text(),'Types of Binary Trees')]")WebElement typesOfBinaryTrees;
	@FindBy (xpath="//a[contains(text(),'Implementation in Python')]")WebElement implementationInPython ;
	@FindBy (xpath="//a[contains(text(),'Binary Tree Traversals')]")WebElement binaryTreeTraversals;
	@FindBy (xpath="//a[contains(text(),'Implementation of Binary Trees')]")WebElement implementationOfBinaryTrees;
	@FindBy (xpath="//a[contains(text(),'Applications of Binary trees')]")WebElement applicationOfBinaryTrees;
	@FindBy (xpath="//a[contains(text(),'Binary Search Trees')]")WebElement binarySearchTrees ;
	@FindBy (xpath="//a[contains(text(),'Implementation Of BST')]")WebElement implementationOfBST;
	@FindBy (id="output")
	static WebElement output; 
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%	
	public CollectionsPage()
	{
		PageFactory.initElements(driver, this);
		//this.driver=driver;
	}	
	
//******************************  Main Page  ***************************************	
	public void getPage() throws IOException
	 {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getApplicationUrl();
		driver.get(URL);		
	 }
	public void clickOngetStarted() throws InterruptedException
	{	
		driver.findElement(getStarted).click();
		Thread.sleep(500);
	}
	public void clickOndropDownDS()
	{
		dropDown.click();
	}
	public void clickOneFromDropDown() {
		dropDown_stack.click();
	}
	
	public void clickondataStructureGetstarted()
	{
	dataStructureDropDown.click();
		
	}
	public void signIn() {
		sign_In.click();
	}
	public void clickonRegister()
	{
		driver.findElement(registerBut).click();
			
	}
	public String getPageTitle() {
		String title = driver.getTitle();
		return title; 
	}

	public static String errorMessage() {	
			String error_Message = alert_msg.getText();
			return error_Message;		
	}

//******************************  Login  ***************************************
	public void LoginPage() throws IOException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getLoginPage();
		driver.get(URL);
	}
	
	public void loginWithCredentials(String username, String password) throws InterruptedException {
		driver.findElement(login_Username).sendKeys(username);	
		driver.findElement(login_Password).sendKeys(password);
		driver.findElement(login_Button).click();
	}
	
	public String login_page() {
		String title = driver.getTitle();
		return title;
	}
	
//******************************  Data Structure  ***************************************
 		
	public void dataStructure()
	{
		//driver.findElement(getStartedDS).click();	
		driver.get(DataStructureURL);
	}
	
	public void TryHere() 	
	{   JavascriptExecutor executor= (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(getTimeComplexity).click();
		driver.findElement(tryhere).click();	
	}
	public void enterPythonCode(int sheetNumber, int rownumber) throws InvalidFormatException, IOException 
	{		
		String code=eleUtil.getCodefromExcel(sheetNumber, rownumber);
		eleUtil.enterCode(code,editorInput);
		driver.findElement(runButton).click();		
	}
	
	public String getExpectedResult(Integer sheetNumber, Integer rowNumber) throws InvalidFormatException, IOException {
		String expectedResult = eleUtil.getResultfromExcel(sheetNumber, rowNumber);
		return expectedResult;
	}
	
	public void backToHome() throws IOException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getHomePage();
		driver.get(URL);		
	}
	
//******************************  Array  ***************************************

	
	
	public void clickArray() throws IOException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getArrayUrl();
		driver.get(URL);	
	}
	public void clickArraysInPython() {
		arraysInPython.click();
	}
	
	public void clickArraysUsingList() {
		arraysUsingList.click();
	}
	public void clickBasicOperationinLists() {
		arraysBasicOperationinList.click();
	}
	public void clickApplicationsOfArray() {
		arraysApplicationofArray.click();
	}
	
	public void clicktryHere() {
		tryHere.click();
	}
	public void enterPythonCode(String sheetName, int rownumber) throws InvalidFormatException, IOException 
	{		
		String code=eleUtil.getCodefromExcel(sheetName, rownumber);
		eleUtil.enterCode(code,editorInput);
		driver.findElement(runButton).click();		
	}
	public static String getExpectedResult(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		String expectedResult = eleUtil.getResultfromExcel(sheetName, rowNumber);
		return expectedResult;
	}
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	public void clickPracticeQuestions() {
		practiceQuestionsinArray.click();
	}
	public void clickSearchTheArray() {
		SearchTheAarray.click();
	}
	public void clickPracticeQuestionArray() throws IOException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getPracticeUrl();
		driver.get(URL);	
	}
	
	public void clickMaxConsecutiveOnes() {
		maxConsecutiveOnes.click();
	}	
	
	public void clickfindNumbersWithEvenNumberOfDigits()
	{
	findNumbersWithEvenNumberOfDigits.click();
	}

	public void squaresOfASortedArray()
	{
	squaresOfASortedArray.click();
	}
	public void clearCodeInTextEditorBox() {
		driver.findElement(enterPythonText).sendKeys(Keys.COMMAND , "a");
//	 enterPythontextArea.sendKeys(Keys.CONTROL + "x");
		driver.findElement(enterPythonText).sendKeys(Keys.DELETE);
//	 enterPythontextArea.clear();
	}
	
	public void pythonCode(String string) throws IOException, InterruptedException {
		FileInputStream stream = new FileInputStream(propertyFilePath);
		properties = new Properties();
		properties.load(stream);
		Thread.sleep(500);
		Constants.python_Code=properties.getProperty("pythonCode");
        driver.findElement(enterPythonText).sendKeys(Constants.python_Code);
        //runButtoninPracticeQuestions.click();      
       }

		
	public void errorCode(String PythonCode) throws IOException, InterruptedException {
		FileInputStream stream = new FileInputStream(propertyFilePath);
		properties = new Properties();		
		properties.load(stream);
		Thread.sleep(500);
		Constants.error_Code=properties.getProperty("errorCode");
        driver.findElement(enterPythonText).sendKeys(Constants.error_Code);
        runButtoninPracticeQuestions.click();      
       }
	
	public void arrayPracticeQuestion(String pythoncode) throws InvalidFormatException, IOException, InterruptedException {
		//inputBox.click();
		Thread.sleep(500);
		driver.findElement(enterPythonText).sendKeys(pythoncode);
		runButtoninPracticeQuestions.click();
	}
	
	public void clickRun() {
	driver.findElement(runButton).click();	
	}
	
	public static String getActualResult() {
		eleUtil.WaitForElement(output);
		return output.getText();
	}
	
	public static String getErrorText() throws InterruptedException {
	Thread.sleep(500);
	String errorMsg = driver.switchTo().alert().getText();
	Loggerload.info("The Error Message is:" +errorMsg);
	driver.switchTo().alert().accept();
	return errorMsg;
}
	
//	public String getOutput() {
//		ElementsUtils.waitForElement(outputText);
//	   String output=outputText.getText();
//	   return output;
//
	
	
 
//******************************  Linked List  ***************************************
	

	public void clickLinkedList() throws IOException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getLinkedListUrl();
		driver.get(URL);		
	}
	public void clickIntroduction() {
		introduction.click();
	}
	
	public void clickcreatingLinkedList() throws InterruptedException {
		Thread.sleep(500);
		creatingLinkedList.click();
	}
	
	public void clickTypesofLinkedLists() {
		typesOfLinkedList.click();
	}
	public void clickImplementLinkedListinPython() {
		implementLinkedList.click();
	}
	public void clickTraversal() {
		traversal.click();
	}
	public void clickInsertion() {
		insertion.click();
	}
	public void clickDeletion() {
		deletion.click();
	}
//********************************** Stack *******************************************	
	public void clickStack() throws IOException, InterruptedException {
		Thread.sleep(500);
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getStackUrl();
		driver.get(URL);		
	}
	public void clickOperationInStack() {
		operationsInStack.click();
	}
	
	public void clickImplementation() {
		implementation.click();
	}
	
	public void clickApplications() {
		applications.click();
	}	
//********************************** Queue *******************************************	
	
	public void clickQueue() throws IOException, InterruptedException {
		Thread.sleep(500);
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getQueueUrl();
		driver.get(URL);		
	}
	public void clickImplementationOfQueueInPython() {
		implementationOfQueueInPython.click();
	}	
	public void clickImplementationUsingCollectionsDequeue() {
		implementationUsingCollectionsDequeue.click();
	}
	
	public void clickImplementationUsingArray() {
		implementationUsingArray.click();
	}
	
	public void clickQueueOperations() {
		queueOperations.click();
	}
//********************************** Graph *******************************************	
	
	public void clickGraphLink() throws IOException  {
 
		JavascriptExecutor executor= (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollBy(0,750)", "");
		graphLink.click();
	}
	
	public void clickGraphPage() throws IOException, InterruptedException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getGraphGraphUrl();
		Thread.sleep(500);
		driver.get(URL);		
	}
	
	public void loginWithUernamePwd(String string, String string2) throws InterruptedException, IOException {
		//ConfigReader.loadConfig();
		FileInputStream stream = new FileInputStream(propertyFilePath);
		properties = new Properties();		
			properties.load(stream);
		 
		Constants.user_name=properties.getProperty("USERNAME");
		Constants.pass_word=properties.getProperty("PASSWORD");
		Thread.sleep(500);
		driver.findElement(login_Username).sendKeys(Constants.user_name);	
		driver.findElement(login_Password).sendKeys(Constants.pass_word);
		driver.findElement(login_Button).click();
	}
	
	
	public void clickGraph() {
		graph.click();
	}	
	public void clickGraphRepresentation() {
		graphRepresentations.click();
	}
	//********************************** Tree *******************************************			
	public void clickTree() throws IOException, InterruptedException {
		ConfigReader.loadConfig();				
		String URL=ConfigReader.getTreeUrl();
		Thread.sleep(500);
		driver.get(URL);		
	}
	
	public void clickOverviewOfTrees() {
		overviewOfTrees.click();	
	}	
	
	public void clickTerminologies() {
		terminologies.click();
	}
	
	public void clickTypesOfTrees() {
		typesOfTrees.click();
	}
	
	public void clickTreeTraversal() {
		treeTraversal.click();
	}	

	public void clickTraversalsIllustration() {
		traversalsIllustration.click();
	}

	public void clickBinaryTrees() {
		binaryTrees.click();
	}

	public void clickTypesOfBinaryTrees() {
		typesOfBinaryTrees.click();
	}
	
	public void clickBinaryTreeTraversals() {
		binaryTreeTraversals.click();
	}
	
	public void clickImplementationInPython() {
		implementationInPython.click();
	}

	public void clickImplementationOfBinaryTrees() {
		implementationOfBinaryTrees.click();
	}

	public void clickApplicationOfBinaryTrees() {
		applicationOfBinaryTrees.click();
	}

	public void clickBinarySearchTrees() {
		binarySearchTrees.click();
	}
	
	public void clickImplementationOfBST() {
		implementationOfBST.click();
	}
	
}
