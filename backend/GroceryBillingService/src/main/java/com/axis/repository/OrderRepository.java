package com.axis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Order;
@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

}
