package com.axis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.axis.dto.ProductDto;
import com.axis.exception.InvalidProductException;
import com.axis.exception.ProductNotFound;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;
import com.axis.utils.AppConstants;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	// from Product to ProductDto
	private ProductDto convertToDto(Product product) {
		ProductDto productDto = new ModelMapper().map(product, ProductDto.class);
		return productDto;
	}

	// from ProductDto to Product
	private Product convertToEntity(ProductDto productDto) {
		Product product = new ModelMapper().map(productDto, Product.class);
		return product;
	}

	@Override
	public ProductDto addProduct(ProductDto productdto) {
		if (productdto.getProductPrice() < 0.0 || productdto.getProductQuantity() < 0) {
			throw new InvalidProductException(AppConstants.INVALID_PRODUCT_MESSAGE);
		}

		// productRepository.save(convertToEntity( new
		// Product(productdto.getProductId(),productdto.getProductName(),productdto.getProductCategory(),productdto.getProductBrand(),
		// productdto.getProductPrice(),productdto.getProductQuantity(),productdto.getProductImageURL())));

		Product product = productRepository.save(convertToEntity(productdto));
		return convertToDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productRepository.findAll();

		for (Product product : products) {
			productDtos.add(convertToDto(product));
		}

		if (products.size() <= 0) {
			throw new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE);
		}
		return productDtos;
	}

	@Override
	public List<ProductDto> getAllByProductCategory(String productCategory) {
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productRepository.getProductsByCategoryR(productCategory);
		for (Product product : products) {
			productDtos.add(convertToDto(product));
		}
		if (products.size() == 0) {
			throw new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE);
		}
		return productDtos;
	}
	// -----------------------------------------------------

	@Override
	public Product updateProduct(String productId, Product product) {

		Optional<Product> products = productRepository.findById(productId);

		if (products.isPresent()) {
			Product product1 = products.get();
			product1.setProductName(product.getProductName());
			product1.setProductCategory(product.getProductCategory());
			product1.setProductBrand(product.getProductBrand());
			product1.setProductPrice(product.getProductPrice());
			product1.setProductQuantity(product.getProductQuantity());
			product1.setProductImageURL(product.getProductImageURL());
			productRepository.insert(product1);
		}
		return product;

		// -------------------------------------------------------------------

	}

	@Override
	public String deleteProduct(String productId) {

		List<Product> products = productRepository.deleteByProductId(productId);
		productRepository.deleteAll(products);
		if (products.size() == 0) {
			throw new ProductNotFound(AppConstants.PRODUCT_NOT_FOUND_MESSAGE);
		}
		return "Product Deleted";
	}

	@Autowired
	private MongoTemplate mongoTemplate1;

	@Override
	public List<Product> fullTextSearch(String searchPhrase) {
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingPhrase(searchPhrase);

		Query query = TextQuery.queryText(criteria).sortByScore();

		List<Product> products = mongoTemplate1.find(query, Product.class);
	
		return products;
	}

}
