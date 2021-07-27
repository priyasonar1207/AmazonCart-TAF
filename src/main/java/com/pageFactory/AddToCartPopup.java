package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.generic.BaseTest;
import com.generic.WrapperFunctions;

public class AddToCartPopup {

	WrapperFunctions objWrapperFunctions=new WrapperFunctions();
	By loc_hdrAddedToCart = By.xpath("//div[@class='a-section a-spacing-none a-padding-base attach-primary-atc-confirm-box']//div[@id='attachDisplayAddBaseAlert']//h4[contains(.,'Added to Cart')]");
	By loc_noOfItemAddedToCart = By.xpath("//span[@id='attach-accessory-cart-total-string'][contains(.,' (1 item): ')]");
	By loc_btnCart = By.xpath("//div[@class='a-section a-spacing-none a-padding-base attach-primary-atc-confirm-box']//form[@id='attach-view-cart-button-form']//input[@type='submit']");
	
	//verify added to cart popup is displayed
			public void verifyAddedToCartPopupIsDisplayed() {
				objWrapperFunctions.setWaitForElementToBeVisible(30, loc_hdrAddedToCart);
				BaseTest.driver.findElement(loc_hdrAddedToCart).isDisplayed();
				Assert.assertTrue(BaseTest.driver.findElement(loc_hdrAddedToCart).isDisplayed(),"Added to Cart Popup is displayed");
				System.out.println("Added to Cart Popup is displayed");
		    }
			

			//verify 1 item is added to cart
					public void verifyNoOfItemsAddedToCart() {
						BaseTest.driver.findElement(loc_noOfItemAddedToCart).isDisplayed();
						Assert.assertTrue(BaseTest.driver.findElement(loc_noOfItemAddedToCart).isDisplayed(),"1 item Added to Cart Popup is not displayed");
						System.out.println("1 item Added to Cart Popup is displayed");
				    }
					

					//click on cart
							public void clickOnCartButton() {
								BaseTest.driver.findElement(loc_btnCart).isDisplayed();
								Assert.assertTrue(BaseTest.driver.findElement(loc_btnCart).isDisplayed(),"Cart button is not displayed");
								objWrapperFunctions.clickOnWebElementUsingActions(loc_btnCart);
								System.out.println("Click on cart");
						    }
}
