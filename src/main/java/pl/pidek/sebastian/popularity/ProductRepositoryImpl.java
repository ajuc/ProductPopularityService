package pl.pidek.sebastian.popularity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryImpl implements ProductRepository {
	private HashMap<Long, Product> products;
	private HashMap<Long, Integer> views;
	
	public ProductRepositoryImpl() {
		long id = 1l;
		products = new HashMap<>();
		views = new HashMap<>();
		products.put(id, new Product(id++, "Hammer", "Kinetic Energy Applicator", ProductKind.MALE, new BigDecimal("79.99")));
		products.put(id, new Product(id++, "Fishing Rod", "Better than a Fish", ProductKind.MALE, new BigDecimal("299.99")));
		products.put(id, new Product(id++, "Nordic Walking Sticks", "Sticks for Nordic Walking", ProductKind.FEMALE, new BigDecimal("139.99")));
		products.put(id, new Product(id++, "Handbag", "Bag of Holding", ProductKind.FEMALE, new BigDecimal("249.99")));
		products.put(id, new Product(id++, "Puzzle Box", "Patience Trainer", ProductKind.KID, new BigDecimal("79.99")));
		products.put(id, new Product(id++, "Smartphone", "Parents' Attention Replacement", ProductKind.KID, new BigDecimal("579.99")));
		
		products.values().forEach( p -> views.put(p.getId(), 0) );
	}
	
	@Override
	public void increaseViews(long id) {
		views.put(id, views.getOrDefault(id, 0) + 1);
	}
	
	@Override
	public ProductDTO getProductById(long id) {
		if (products.get(id) == null || views.get(id) == null)
			return null;
		return new ProductDTO(products.get(id), views.get(id));
	}

	@Override
	public Collection<ProductDTO> getProductsByName(String name) {
		return products.values().stream()
				.filter( p -> p.getName().equals(name))
				.map(p -> new ProductDTO(p, views.get(p.getId())))
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<ProductDTO> getAllProducts() {
		return products.values().stream()
				.map(p -> new ProductDTO(p, views.get(p.getId())))
				.collect(Collectors.toList());		
	}

	@Override
	public ProductDTO save(Long id, ProductDTO newProduct) {
		products.put(
				id,
				new Product(
						id,
						newProduct.getName(),
						newProduct.getDescription(),
						newProduct.getKind(),
						newProduct.getPrice().divide(BigDecimal.ONE.subtract(newProduct.getKind().getRebate()))
				)
		);
		views.put(id, newProduct.getViews());
		return newProduct;
	}

	@Override
	public void deleteById(Long id) {
		products.remove(id);
		views.remove(id);
	}
	
}
