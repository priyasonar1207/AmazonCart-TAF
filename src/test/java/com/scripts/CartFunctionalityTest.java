package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.AddToCartPopup;
import com.pageFactory.AmazonBasicsPage;
import com.pageFactory.CartPage;
import com.pageFactory.HomePage;
import com.pageFactory.ProductPage;

public class CartFunctionalityTest extends BaseTest{

	private HomePage objHomePage;
	private AmazonBasicsPage objAmazonBasicsPage;
	private ProductPage objProductPage;
	private AddToCartPopup objAddToCartPopup;
	private CartPage objCartPage;
	
	       // Initialize Views
			public void initializeViewsAndPages() {
				objHomePage=new HomePage();
				objAmazonBasicsPage=new AmazonBasicsPage();
				objProductPage=new ProductPage();
				objAddToCartPopup=new AddToCartPopup();
				objCartPage=new CartPage();
			}

	@BeforeClass
	public void initializeEnvironment() {
		initialiseWebEnvironment();
		this.initializeViewsAndPages();
	}
	
	@AfterClass
	public void tearDownEnvironment(){
		teardown();
		}
	
	
	@Test(priority=1,description="Verify amazon product is added in to the cart")
	public void validateAddToCartFunctionality() {
		objHomePage.verifyAmazonHomePageIsDisplayed();	
		objHomePage.verifyAmazonBasicsIsDisplayed();
		objHomePage.clickOnSeeMoreOfAmazonBasics();
		objAmazonBasicsPage.verifyAmazonBasicsPageIsDisplayed();
		objAmazonBasicsPage.verifyFromOurBrandsHeaderIsDisplayed();
		objAmazonBasicsPage.clickOnOurBrandCheckbox();
		objAmazonBasicsPage.verifyOurBrandsCheckboxIsSelected();
		objAmazonBasicsPage.getListOfProducts();
		objProductPage.verifySelectedProductPageIsDisplayed();
		objProductPage.verify8sheetSizeIsSelected();
		objProductPage.clickOnAddToCart();
		objAddToCartPopup.verifyAddedToCartPopupIsDisplayed();
		objAddToCartPopup.verifyNoOfItemsAddedToCart();
		objAddToCartPopup.clickOnCartButton();
		objCartPage.verifyShoppingCartPageIsDisplayed();
		objCartPage.verifyNoOfItemsInSubtotalIsDisplayed();
		
	}
}
