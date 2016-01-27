package mystore.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mystorebusiness.cart.delivery.DeliveryMode;

public class DeliveryTest {

	@Test
	public void test() {
		// fail("Not yet implemented");

		DeliveryMode freeDelivery = new DeliveryMode("at-home-post",
				"At home, by post", 0.00);
		assertEquals("The delivery mode is free ", true, freeDelivery.isFree());

		DeliveryMode notFreeDelivery = new DeliveryMode("at-home-post",
				"At home, by post", 1.00);
		assertEquals("The delivery mode is not free ", false,
				notFreeDelivery.isFree());

	}

}
