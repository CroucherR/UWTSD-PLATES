package com.example.pinpointpersonalplates.Config;


import com.example.pinpointpersonalplates.model.Customer;
import com.example.pinpointpersonalplates.model.Payment;
import com.example.pinpointpersonalplates.model.Plates;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer
{
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors)
    {
        config.exposeIdsFor(Plates.class);
        config.exposeIdsFor(Payment.class);
        config.exposeIdsFor(Customer.class);
    }
}
