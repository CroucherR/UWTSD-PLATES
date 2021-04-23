package com.example.pinpointpersonalplates;

import com.example.pinpointpersonalplates.model.Customer;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PinpointpersonalplatesApplicationTests
{
    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestRestTemplate restTemplate;

    private String GetURL(String... params)
    {
        String url = "http://localhost:"+ port;

        for(String p :params)
        {
            url += "/"+p;

        }
        return url;

    }

    @Test
    public void TestIncorrectTypeCustomerGet() throws IOException {
        HttpUriRequest request = new HttpGet(GetURL("customer", "hello"));
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(1)
    public void TestCustomerPostSuccessfulHttpCode() throws URISyntaxException
    {
        URI uri = new URI(GetURL("customer"));
        Customer customer = new Customer();
        customer.setFirstname("Riley");
        customer.setSecondname("Croucher");
        customer.setAddress("Cardiff");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");

        HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri,request, String.class );

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void TestCustomerGetDataSuccessful() throws URISyntaxException
    {
        URI uri = new URI(GetURL("customer", "1"));

        ResponseEntity<Customer> response = restTemplate.getForEntity(uri, Customer.class);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        Assert.assertEquals("Riley", response.getBody().getFirstname());
        Assert.assertEquals("Croucher", response.getBody().getSecondname());
        Assert.assertEquals("Cardiff", response.getBody().getAddress());
    }

}
