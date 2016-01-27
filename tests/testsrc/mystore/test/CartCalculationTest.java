package mystore.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mystorebusiness.cart.Cart;
import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.product.Product;

public class CartCalculationTest {

	@Test
	public void testCartCalculation() throws FunctionnalException {

		Cart cart = new Cart("00000001");
		Product babyNappies = new Product("0000123", 1.99,
				"Luxury Baby Nappies Size 4");
		// Just one product
		cart.addProduct(babyNappies, 1);

		assertEquals("Cart Total is  ", new Double(1.99), cart.getTotal());
	}

	@Test
	public void testAddToCart() throws FunctionnalException {

		Cart cart = new Cart("00000001");

		Product babyNappies = new Product("0000123", 1.99,
				"Luxury Baby Nappies Size 4");

		cart.addProduct(babyNappies, 1);
		cart.addProduct(babyNappies, 1);

		// Case 1
		assertEquals("Cart Total is  ", new Double(3.98), cart.getTotal());

		Product babyTissues = new Product("0000124", 1.25,
				"Baby tissue alcohool free");
		cart.addProduct(babyTissues, 1);

		// Case 2
		assertEquals("Cart  new total is  ", new Double(5.23), cart.getTotal());

	}

	@Test
	public void testShippingCost() throws FunctionnalException {

		Cart cart = new Cart("000000002");

		Product babyNappies = new Product("0000123", 1.99,
				"Luxury Baby Nappies Size 4");
		Product babyTissues = new Product("0000124", 1.25,
				"Baby tissue alcohool free");
		// Add some products
		cart.addProduct(babyNappies, 1);
		cart.addProduct(babyTissues, 1);

		// add a shipping cost
		cart.addShippingCost(1.00);

		assertEquals("Cart  new total is  ", new Double(4.24), cart.getTotal());

	}
}
