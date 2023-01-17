package com.axis.service;

import java.util.List;

import com.axis.dto.ProductDto;
import com.axis.model.Product;

public interface ProductService {

	public ProductDto addProduct(ProductDto productdto);

	public List<ProductDto> getAllProducts();

	public List<ProductDto> getAllByProductCategory(String productCategory);

	public Product updateProduct(String productId, Product product);

	public String deleteProduct(String productId);

	public List<Product> fullTextSearch(String searchPhrase);

}
