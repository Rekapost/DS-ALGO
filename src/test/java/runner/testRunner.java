package runner;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;  //***************  junit
import io.cucumber.testng.CucumberOptions;   //***************  testng
import io.cucumber.testng.AbstractTestNGCucumberTests;
/*DONE DATA DRIVEN USING EXAMPLES SECNARIO OUTLINE,  EXCEL FILE,   DATATABLE  
 *DONE READING DATA FROM EXCEL FILE STORED IN SYSTEM USING SHEET NUMBER ,SHEET NAME 
 *DONE READING DATA FROM EXCEL FILE STORED IN  RESOURCE FOLDER USING SHEET NUMBER ,SHEET NAME  
 *DONE READING USERNAME AND PASSWORD FROM CONFIG.PROPERTIES FILE
 *DONE READING USERNAME AND PASSWORD WITH HARDCODED VALUES IN FEATURE FILE 
 *DONE NEGATIVE TESTING   
 *DONE CROSS BROWSER TESTING 
 *DONE AUTOMATION USING PAGE OBJECT MODEL
 *CREATED LOGS USING LOG4J
 *DONE EXCEPTION HANDLING 
 *RAN THE CODE USING JUNIT and TESTNG
 *USED CONFIG.PROPERTIES FILE,CONFIG READER, EXCEL READER, CONSTANTS, LOG4J, HOOKS,CROSS BROWSER
 *GENERATED EXTENT PDF REPORT , EXTENT SPARK HTML REPORT AND CUCUMBER HTML REPORT    */
//	@RunWith(Cucumber.class)    //***************  junit
//	@CucumberOptions(           //***************  junit
      @CucumberOptions(            //***************  testng
			//features = "src/test/resources/features/01_mainPage.feature",
			//features = "src/test/resources/features/02_registerPage.feature",
			//features ="src/test/resources/features/03_signIn.feature",
			//features = "src/test/resources/features/04_dataStructure.feature",
//			features = "src/test/resources/features/05_array.feature",
 			//features = "src/test/resources/features/06_linkedList.feature",
			//features = "src/test/resources/features/07_stack.feature",
			//features = "src/test/resources/features/08_queue.feature",
			//features = "src/test/resources/features/10_graph.feature",
			//features = "src/test/resources/features/11_tree.feature",
	       
		    //tags=  "@homepage,@signIn,@dataStructure,@array ,@graph",
			features = "src/test/resources/features/",
			glue =  { "StepDefinition", "hooks" },
			plugin = { "pretty",
					
             "html:target/cucumber-reports/dsalgo.html",
             "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//             "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
			dryRun=false,
			monochrome = true			 
	)
// allure serve C:\Users\Reka\git\DS-ALGO-94NN\allure-results
	public class testRunner extends AbstractTestNGCucumberTests {
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}

}
