package com.example.pinpointpersonalplates.repository;

import com.example.pinpointpersonalplates.model.Payment;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "payment", path ="payment")
@CrossOrigin
public interface PaymentRepository extends CrudRepository<Payment, Integer>
{

}
