package edu.mum.eselling.service;

import java.util.List;

import edu.mum.eselling.domain.Product;

public interface ProductService {

	public List<Product> findPendingProducts();

	public List<Product> findApprovedProducts();

	public Product find(Long productId);

	public List<Product> findProductsByCategory(Long categoryId);

	public Product save(Product product);

	public List<Product> getAllProductsByVendorId(Long VendorId);

	public List<Product> findProductsByName(String productName);

	public Product getProductById(Long productId);
}
