package com.example.pinpointpersonalplates.repository;


import com.example.pinpointpersonalplates.model.Plates;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "plates", path="plates")
@CrossOrigin("*")
public interface PlatesRepository extends PagingAndSortingRepository<Plates, Integer>
{
    @Cacheable("FindPartial")
    List<Plates> findByRegistrationplateContainingIgnoreCase(@Param("registrationplate") String plate);
    @Cacheable("FindFull")
    List<Plates> findByRegistrationplateIgnoreCase(@Param("registrationplate") String plate);
}
