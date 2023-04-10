package StepDefinition;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.registerPage;
import utilities.ConfigReader;
import utilities.Loggerload;
//import pages.mainPage;   *********************

public class registerPage_step {
	//WebDriver driver = new ChromeDriver();
	//String url = "https://dsportalapp.herokuapp.com/register";
	
	registerPage rp=new registerPage();
//
	@Given("The user opens Register Page")
	public void the_user_opens_register_page() throws IOException {
		rp.getRegisterPage();
		Loggerload.info("user get into the Register page");   
	}
	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		rp.clickRegisterLink();
		rp.clickSubmitRegister();
	}
	
	@Then("It should display an error message {string} below Username textbox")
	public void it_should_display_an_error_message_below_username_textbox(String string) {
		String errorMessage=  rp.getEmptyfieldErrormsgUser();
		Loggerload.info("errror message : " +errorMessage);
	}
	
	@When("The user  enters {string} with other fields empty and user clicks register button")
	public void the_user_enters_with_other_fields_empty_and_user_clicks_register_button(String string, io.cucumber.datatable.DataTable dataTable) throws IOException {
		rp.clickRegisterLink();
		Loggerload.info("The user  enters username with other fields empty " );
		rp.enterUsername(dataTable);
		rp.clickSubmitRegister();	
		String Page_Title=rp.getPageTitle();
		Loggerload.info("Page Title : "+Page_Title ); 
		rp.screenShot();
		//assertEquals(Page_Title, "Login", "Title do not match");
		
//		String expectedmessage = dataTable.get(rownumber).get("username");
//		String actualSuccMessg = contactUsPage.getSuccessMessg();
//		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}
	
	@Then("It should display an error message {string} below Password textbox")
	public void it_should_display_an_error_message_below_password_textbox(String string) {
		 String errorMessage=  rp.getEmptyfieldErrormsgUser();
		 Loggerload.info("errror message : " +errorMessage);
	}

	@When("The user  enters {string} and {string} with Password Confirmation field empty and user clicks register button")
	public void the_user_enters_and_with_password_confirmation_field_empty_and_user_clicks_register_button(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		rp.clickRegisterLink();
		Loggerload.info("The user  enters username and password with Password Confirmation field empty " );
		rp.enterUsername(dataTable);
		rp.enterPassword(dataTable);
		rp.clickSubmitRegister();			
	}
	
	@Then("It should display an error message {string} below Password Confirmation textbox")
	public void it_should_display_an_error_message_below_password_confirmation_textbox(String string) {
		 String errorMessage=  rp.getEmptyfieldErrormsgConfrmPwd();
		 Loggerload.info("errror message : " +errorMessage);
	}
	
	@When("The user enters a {string} with characters other than Letters, digits and @\\/.\\/+\\/-\\/_   with {string} and {string} and user clicks register button")
	public void the_user_enters_a_with_characters_other_than_letters_digits_and_with_and_and_user_clicks_register_button(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {	    
		rp.clickRegisterLink();
		Loggerload.info("The user enters a username with characters other than Letters, digits and @/./+/-/_   with password and confirm_password"   );
		rp.enterUsername(dataTable);
		rp.enterPassword(dataTable);
		rp.enterConfmPassword(dataTable);
		rp.clickSubmitRegister();
		
	}
	
	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string) {
		rp.getErrorMsg();		
	}
	
	@When("The user enters {string} and different passwords in {string} and {string} fields and user clicks register button")
	public void the_user_enters_and_different_passwords_in_and_fields_and_user_clicks_register_button(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		rp.clickRegisterLink();
		Loggerload.info("The user enters username and different passwords " );
		rp.enterUsername(dataTable);
		rp.enterPassword(dataTable);
		rp.enterConfmPassword(dataTable);
		rp.clickSubmitRegister();
		
	}
	@When("The user enters {string} and {string} with characters less than eight and {string} and user clicks register button")
	public void the_user_enters_and_with_characters_less_than_eight_and_and_user_clicks_register_button(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		rp.clickRegisterLink();
		Loggerload.info("The user enters username and password with characters less than eight and confirm_password  " );
		rp.enterUsername(dataTable);
		rp.enterPassword(dataTable);
		rp.enterConfmPassword(dataTable);	
		rp.clickSubmitRegister();
		
	}
	
	@When("The user enters {string} and   {string} with only numbers and {string} and user clicks register button")
	public void the_user_enters_and_with_only_numbers_and_and_user_clicks_register_button(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		rp.clickRegisterLink();
		Loggerload.info(" The user enters username and   password with only numbers and confirm_password " );
		rp.enterUsername(dataTable);
		rp.enterPassword(dataTable);
		rp.enterConfmPassword(dataTable);
		rp.clickSubmitRegister();
		
	}
	
	@When("The user clicks Register button after entering {string}, {string} and {string}")
	public void the_user_clicks_register_button_after_entering_and(String username,String password,String confirm_password) throws InterruptedException {
		rp.register_link(username, password, confirm_password);	
		Loggerload.info("user   successfully   Registered"); 
		String Page_Title=rp.getPageTitle();
		Loggerload.info("Page Title : "+Page_Title ); 
	}
	
	@Then("It should go to homepage and get message  {string}")
	public void it_should_go_to_homepage_and_get_message(String string) {
		Loggerload.info("User redirected to login page ");
		String Title = rp.register_page();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, "Registration", "Title do not match");
		//rp.getRegisterAlert();
		//rp.getSignIn();
	}
	@When("The user enters a valid existing {string} with {string} and {string}")
	public void the_user_enters_a_valid_existing_with_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		rp.clickRegisterLink();
		Loggerload.info("The user enters a valid existing username with password and confirm_password" );
		rp.enterUsername(dataTable);
		rp.enterPassword(dataTable);
		rp.enterConfmPassword(dataTable);
		rp.clickSubmitRegister();
	}
}
