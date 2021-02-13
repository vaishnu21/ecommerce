package Ecom.Admin.TestCases;



import org.testng.annotations.Test;
import Ecom.Base.TestBase;
import Ecom.Pages.AccountPage;
import Ecom.Pages.Homepage;


public class TestHomepage extends TestBase {
	
AccountPage AccountPag;
	public TestHomepage()
	{
		super();
	}
	@Test
	public void Startup()
	{
		setup();
		Homepage HomePag=new Homepage();
		AccountPag=HomePag.ClickAccount();
	}
}
