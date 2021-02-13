package Ecom.Admin.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Ecom.Base.TestBase;
import Ecom.Pages.Accessories;
import Ecom.Pages.AccountPage;
import Ecom.Pages.CartPage;
import Ecom.Pages.Homepage;

public class TestAccessories extends TestBase {
	Accessories AccessoriesPag;
	AccountPage AccountPag;
	CartPage CartPag;

	public TestAccessories() {
		super();
	}

	@BeforeClass
	public void Startup() {
		setup();
		Homepage Hpag = new Homepage();
		AccountPag = Hpag.ClickAccount();
		AccountPag.Login(pop.getProperty("username"), pop.getProperty("password"));
		AccessoriesPag = AccountPag.ClickAccessories();

	}

	@Test
	public void ShoppingProduct() {
		AccessoriesPag.ClickProduct();
		AccessoriesPag.AddToCart();
		CartPag = AccessoriesPag.ViewCart();
	}
}
