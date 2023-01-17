package com.axis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@Query("{productCategory : ?0}")
	public List<Product> getProductsByCategoryR(String productCategory);
	
	@Query("{productId : ?0}")
	public List<Product> deleteByProductId(String productId);

}
