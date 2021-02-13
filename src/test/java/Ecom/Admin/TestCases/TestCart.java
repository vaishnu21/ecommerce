package Ecom.Admin.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Ecom.Base.TestBase;
import Ecom.Pages.Accessories;
import Ecom.Pages.AccountPage;
import Ecom.Pages.CartPage;
import Ecom.Pages.CheckOutPage;
import Ecom.Pages.Homepage;

public class TestCart extends TestBase{
	AccountPage AccountPag;
	Accessories AccessoriesPag;
	CheckOutPage CheckOutPag;
	CartPage CartPag;
public TestCart()
{
	super();
}
@BeforeClass
public void Startup()
{
	setup();
	Homepage Hpag=new Homepage();
	AccountPag=Hpag.ClickAccount();
	AccountPag.Login(pop.getProperty("username"),pop.getProperty("password"));
	AccessoriesPag=AccountPag.ClickAccessories();
}
@Test(priority=1)
public void ShoppingProduct()
{
	AccessoriesPag.ClickProduct();
	AccessoriesPag.AddToCart();
	CartPag=AccessoriesPag.ViewCart();
}
@Test(priority=2)
public void ClickCheckOut()
{
	CheckOutPag=CartPag.ProceedToCheckOut();
}
}
