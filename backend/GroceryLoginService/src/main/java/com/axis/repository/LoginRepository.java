package com.axis.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, String>{
	

}
