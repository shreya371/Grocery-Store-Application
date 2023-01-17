package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.ProductDto;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;
import com.axis.service.ProductService;
@CrossOrigin
@RestController
@RequestMapping("/ms1")
public class ProductController {
	@GetMapping("/greet")
	public String sayHello() {
		return "Hello from product service";
	}
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	//ADD PRODUCT
	@PostMapping("/product")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productdto){
		return new  ResponseEntity<ProductDto>(productService.addProduct(productdto),HttpStatus.OK);	
	}
	
	//1)GET all products
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		return new ResponseEntity<List<ProductDto>>(productService.getAllProducts(),HttpStatus.OK);		
	}
	
	
	
	//2)GET all products by productCategory
	
	@GetMapping("/products/{productCategory}")
	public List<ProductDto> getAllByProductCategory(@PathVariable String productCategory){
		return productService.getAllByProductCategory(productCategory);
		
	}
	
	
	//UPDATE product
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/product/{productId}")
	public Product updateProduct(@PathVariable String productId,@RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}

	//DELETE PRODUCT
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable String productId) {
		return productService.deleteProduct(productId);
	}
	
	
	//SEARCH PRODUCTS
	@GetMapping("/search/{searchPhrase}")
	public List<Product> fullTextSearchc(@PathVariable String searchPhrase){
		return productService.fullTextSearch(searchPhrase);
	}
	
	

}
