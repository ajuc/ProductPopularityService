package pl.pidek.sebastian.popularity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
	
//	- nazwa
//	- opis
//	- typ (MALE, FEMALE, KID)
//	- cena (cena powinna być wyliczana z uwzględnieniem rabatu)
	
	private final long id;
	private final String name;
	private final String description;
	private final ProductKind kind;
	private final BigDecimal basePrice;
	

	public Product(long id, String name, String description, ProductKind kind, BigDecimal basePrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.kind = kind;
		this.basePrice = basePrice;		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ProductKind getKind() {
		return kind;
	}
	
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	
	public BigDecimal getPrice() {
		return basePrice.multiply(BigDecimal.ONE.subtract(kind.getRebate())).setScale(2, RoundingMode.HALF_UP);
	}
}
