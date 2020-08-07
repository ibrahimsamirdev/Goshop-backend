package com.goshop.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getAllRoles(){
        String url ="http://localhost:"+port+"/api/role";
        ResponseEntity<Object> response = restTemplate.getForEntity(url,Object.class);
        Assert.assertEquals(200,response.getStatusCodeValue());
    }

    @Test
    public void getAllvendor(){
        String url ="http://localhost:"+port+"/api/user/vendors";
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
    }
}
