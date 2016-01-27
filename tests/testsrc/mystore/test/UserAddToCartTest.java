package mystore.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mystorebusiness.cart.Cart;
import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.product.Product;
import com.mystorebusiness.user.User;

public class UserAddToCartTest {

	@Test
	public void test() throws FunctionnalException {

		User user = new User("xxxx@gmail.com");

		// product 1
		Product nappies = new Product("0000000001", 1.99,
				"Baby nappies size medium");

		user.addToCart(nappies, 2);
		Cart cart = user.getCart();
		assertEquals("Total of cart is   ", new Double(3.98), cart.getTotal());

		// let's buy another product
		Product tissue = new Product("0000000002", 1.50,
				"Tissue for babies alcohool freee");
		user.addToCart(tissue, 1);
		assertEquals("New total of cart is   ", new Double(5.48),
				cart.getTotal());

		// now let remove a Nappies packet , it's seem one packet is enough
		user.addToCart(nappies, -1);
		// 5.48 - 1.99 = 3.49

		assertEquals("New total of cart is   ", new Double(3.49),
				cart.getTotal());

		// lets remove all items
		user.addToCart(nappies, -1);
		user.addToCart(tissue, -1);

		assertEquals("Cart shold be emty   ", new Double(0.00), cart.getTotal());
	}
}
