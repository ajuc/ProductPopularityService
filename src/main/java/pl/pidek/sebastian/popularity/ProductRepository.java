package pl.pidek.sebastian.popularity;

import java.util.Collection;

public interface ProductRepository {
	
	/**
	 * Increase views of the given product by 1.
	 * 
	 * @param id - id of the product
	 */
	void increaseViews(long id);
	
	/**
	 * @param id - id of the product
	 * @return product and views data for the product of the given id. Null if no such product. 
	 */
	ProductDTO getProductById(long id);

	/**
	 * @param name - name of the products to find
	 * @return all the products with the given name and how many views each had. Empty collection if no such products.
	 */
	Collection<ProductDTO> getProductsByName(String name);
	
	/**
	 * @return all the products (and how many views each had).
	 */
	Collection<ProductDTO> getAllProducts();

	/**
	 * @param id - id of the product
	 * @param newProduct data of the new product
	 * @return saved product
	 */
	ProductDTO save(Long id, ProductDTO newProduct);

	/**
	 * Delete the product with the given id
	 * @param id
	 */
	void deleteById(Long id);
}
