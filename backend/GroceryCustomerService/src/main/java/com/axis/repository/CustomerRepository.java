package com.axis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.model.Customer;
import com.axis.model.jsonResponse;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	// db.customer.aggregate([{ $match: {'username':'ananya234'} },{"$project":{"cartTotal":{"$sum":"$cart.productPrice"}}}])
	//@Aggregation(pipeline = {"{'$project':{'username':?0,'cartTotal':{'$sum':'$cart.productPrice'}}}"})
	@Aggregation(pipeline = {"{ $match: {'username':?0} },{'$project':{'cartTotal':{'$sum':'$cart.productPrice'}}}"})
	public jsonResponse cartTotalR(String username);
	
	
	//@Aggregation(pipeline = {"{ '$match': {'username':?0} },{'$project':{'username':?0,'cartTotal':{'$sum':'$cart.productPrice'}}}"})
	//([{ $match: {'username':'ananya234'} },{"$project":{"cartTotal":{"$sum":"$cart.productPrice"}}}])
	 @Query("{'username' : ?0}")  
	 public Customer getCustomerByUsername(String username);

}
