package pl.pidek.sebastian.popularity;

import java.math.BigDecimal;

public class ProductDTO {

	private final long id;
	private final String name;
	private final String description;
	private final ProductKind kind;
	private final BigDecimal price;
	private final int views;
	
	public ProductDTO(Product product, int views) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.kind = product.getKind();
		this.price = product.getPrice();
		this.views = views;
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

	public BigDecimal getPrice() {
		return price;
	}

	public int getViews() {
		return views;
	}
}
