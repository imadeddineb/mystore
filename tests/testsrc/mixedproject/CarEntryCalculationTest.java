package mixedproject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mystorebusiness.cart.CartEntry;
import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.product.Product;

public class CarEntryCalculationTest {

	@Test
	public void testCartEntryCalculation() throws FunctionnalException {

		Product aProduct = initProduct(2.00);
		CartEntry anEntry = initEntry(aProduct, 1);

		assertEquals("Entry total is ", new Double(2.00),
				anEntry.getLineTotalPrice());

		Product aProduct1 = initProduct(1.00);
		CartEntry anEntry1 = initEntry(aProduct1, 2);

		assertEquals("Entry total is ", new Double(2.00),
				anEntry1.getLineTotalPrice());

		Product aProduct2 = initProduct(1.99);
		CartEntry anEntry2 = initEntry(aProduct2, 2);

		assertEquals("Entry total is ", new Double(3.98),
				anEntry2.getLineTotalPrice());

	}

	private CartEntry initEntry(Product aProduct, int quantity)
			throws FunctionnalException {
		CartEntry anEntry = new CartEntry(quantity, aProduct);
		return anEntry;
	}

	private Product initProduct(double price) throws FunctionnalException {
		Product aProduct = new Product("1234", price, "Bay Nappies XL");
		return aProduct;
	}

}
