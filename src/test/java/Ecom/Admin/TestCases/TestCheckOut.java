package Ecom.Admin.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecom.Base.TestBase;
import Ecom.Pages.Accessories;
import Ecom.Pages.AccountPage;
import Ecom.Pages.CartPage;
import Ecom.Pages.CheckOutPage;
import Ecom.Pages.Homepage;
import Ecom.Util.ReadExcel;

public class TestCheckOut extends TestBase{
	AccountPage AccountPag;
	Accessories AccessoriesPag;
	CheckOutPage CheckOutPag;
	CartPage CartPag;
	String sheetName = "PlaceOrder";
	public TestCheckOut()
{
	super();
}
	@BeforeClass
	public void Startup()
	{
		setup();
		Homepage HomePag=new Homepage();
		AccountPag=HomePag.ClickAccount();
		AccountPag.Login(pop.getProperty("username"),pop.getProperty("password"));
		AccessoriesPag=AccountPag.ClickAccessories();
		AccessoriesPag.ClickProduct();
		AccessoriesPag.AddToCart();
		CartPag=AccessoriesPag.ViewCart();
		CheckOutPag=CartPag.ProceedToCheckOut();
	}
	
@DataProvider
public Object[][] GetPaymentData() {
	Object data[][] =ReadExcel.getTestData(sheetName);
	return data;
}
@Test(dataProvider ="GetPaymentData")
public void PaymentDetails(String args[]) {
	//Assert.assertTrue(CheckOutPag.VerifyCheckOut());
	CheckOutPag.PaymentDetails(args);
}

}
