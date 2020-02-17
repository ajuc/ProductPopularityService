package pl.pidek.sebastian.popularity;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ProductTests {

	@Test
	public void testRebateCalculationForFemales() {
		Product p = new Product(1, "Name", "Description", ProductKind.FEMALE, new BigDecimal("1000.00"));
		org.junit.Assert.assertTrue(p.getPrice().equals(new BigDecimal("950.00")));
	}

	@Test
	public void testRebateCalculationForMales() {
		Product p = new Product(1, "Name", "Description", ProductKind.MALE, new BigDecimal("1000.00"));
		org.junit.Assert.assertTrue(p.getPrice().equals(new BigDecimal("950.00")));
	}

	@Test
	public void testRebateCalculationForKids() {
		Product p = new Product(1, "Name", "Description", ProductKind.KID, new BigDecimal("1000.00"));
		org.junit.Assert.assertTrue(p.getPrice().equals(new BigDecimal("900.00")));
	}
}
