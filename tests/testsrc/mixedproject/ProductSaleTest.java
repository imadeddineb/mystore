package mixedproject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mystorebusiness.exception.FunctionnalException;
import com.mystorebusiness.products.Product;

public class ProductSaleTest {

	@Test
	public void testSale() throws FunctionnalException {
		// init test data
		Product aProduct = initProduct();
		aProduct.makeSale(1.00);
		assertEquals("The sale boolean sould return ", true, aProduct.isSold());

	}

	@Test
	public void testSaleException() throws FunctionnalException {
		// init test data
		boolean exceptionThrown = false;
		Product aProduct = initProduct();
		try {
			aProduct.makeSale(2.00);
		} catch (FunctionnalException e) {
			exceptionThrown = true;
		}

		assertEquals("The exception is well thrown ", true, exceptionThrown);

	}

	private Product initProduct() throws FunctionnalException {
		Product aProduct = new Product("1234", 2.00, "Baby nappy");
		return aProduct;
	}

}
