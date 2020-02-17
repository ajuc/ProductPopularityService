package pl.pidek.sebastian.popularity;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class RepositoryTests {
	
	private ProductRepository repository = new ProductRepositoryImpl();;
	
	
	@Test
	public void testFindNonexistingById() {
		org.junit.Assert.assertTrue(repository.getProductById(-1) == null);
	}

	@Test
	public void testFindNonexistingByName() {
		org.junit.Assert.assertTrue(repository.getProductsByName("Nonexisting").isEmpty());
	}

	@Test
	public void testFindById() {
		org.junit.Assert.assertTrue(repository.getProductById(3).getId() == 3);
	}
	
	@Test
	public void testFindByName() {
		Collection<ProductDTO> ps = repository.getProductsByName("Hammer");
		
		org.junit.Assert.assertTrue(ps.size() == 1);
		org.junit.Assert.assertTrue(ps.stream().allMatch(p -> p.getName().equals("Hammer")));
		org.junit.Assert.assertTrue(ps.stream().allMatch(p -> p.getViews() == 0));
	}

	@Test
	public void testFindAll() {
		Collection<ProductDTO> ps = repository.getAllProducts();
		org.junit.Assert.assertTrue(ps.size() == 6);
	}
	
	@Test
	public void testSaveNew() {
		ProductDTO p = new ProductDTO(new Product(10l, "New", "Description", ProductKind.FEMALE, new BigDecimal("100.00")), 0);
		repository.save(10l, p);
		
		org.junit.Assert.assertTrue(repository.getAllProducts().size() == 7);
		org.junit.Assert.assertTrue(repository.getProductById(10l).getName().equals("New"));
	}
	
	@Test
	public void testDelete() {
		repository.deleteById(10l);
		org.junit.Assert.assertTrue(repository.getAllProducts().size() == 6);
		org.junit.Assert.assertTrue(repository.getProductById(10l) == null);
	}
}
