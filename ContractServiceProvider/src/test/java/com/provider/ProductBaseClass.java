package com.provider;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class ProductBaseClass {

	  @Autowired
	    ProductController productController;

	   
	    @BeforeEach
	    public void setup() {
	        RestAssuredMockMvc.standaloneSetup(productController);

	      
	    }
}
