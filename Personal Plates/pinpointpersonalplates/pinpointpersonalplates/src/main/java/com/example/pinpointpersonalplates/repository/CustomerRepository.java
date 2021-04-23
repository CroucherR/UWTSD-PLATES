package com.example.pinpointpersonalplates.repository;

import com.example.pinpointpersonalplates.model.Customer;
import com.example.pinpointpersonalplates.model.Payment;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "customer", path ="customer")
@CrossOrigin
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
