package Ecom.Admin.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Ecom.Base.TestBase;
import Ecom.Pages.Accessories;
import Ecom.Pages.AccountPage;
import Ecom.Pages.Homepage;


public class TestAccount extends TestBase{
	
	AccountPage AccountPag;
	Accessories AccessoriesPag;
public TestAccount()
{
	super();
}
@BeforeClass
public void startup()
{
	setup();
	Homepage HomePag=new Homepage();
	AccountPag=HomePag.ClickAccount();
	AccountPag.Login(pop.getProperty("username"),pop.getProperty("password"));
}
@Test(priority=1)
public void ClickOrder()
{
	AccountPag.clickorder();
	Assert.assertTrue(AccountPag.VerifyOrders());
}
@Test(priority=2)
public void ClickAccessories()
{
	AccessoriesPag=AccountPag.ClickAccessories();
}
}
