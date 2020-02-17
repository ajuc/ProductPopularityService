package pl.pidek.sebastian.popularity;

import java.math.BigDecimal;

public enum ProductKind {
	MALE(new BigDecimal("0.05")),
	FEMALE(new BigDecimal("0.05")),
	KID(new BigDecimal("0.10"));
	
	private final BigDecimal rebate;
	private ProductKind(final BigDecimal rebate) {
		this.rebate = rebate;
	}
	public BigDecimal getRebate() {
		return rebate;
	}
}
