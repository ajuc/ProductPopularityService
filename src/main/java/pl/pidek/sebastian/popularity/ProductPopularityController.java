package pl.pidek.sebastian.popularity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPopularityController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products/{id}")
	ProductDTO product(@PathVariable Long id) {
		ProductDTO p = productRepository.getProductById(id);
		productRepository.increaseViews(id);
		return p;
	}
	
	@GetMapping("/products")
	Collection<ProductDTO> products(@RequestParam(value = "name", defaultValue = "") String name) {
		Collection<ProductDTO> ps;
		if (name.equals("")) {
			ps = productRepository.getAllProducts();
		} else {
			ps = productRepository.getProductsByName(name);
		}
		ps.forEach(p -> productRepository.increaseViews(p.getId()));
		return ps;
	}

	@PutMapping("/products/{id}")
	ProductDTO saveProduct(@RequestBody ProductDTO newProduct, @PathVariable Long id) {
		return productRepository.save(id, newProduct);
	}

	@DeleteMapping("/products/{id}")
	void deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
	}
}