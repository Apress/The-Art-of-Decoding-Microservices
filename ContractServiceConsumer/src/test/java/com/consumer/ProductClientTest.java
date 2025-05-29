package com.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.junit.StrictStubsRunnerTestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.provider.Product;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = LOCAL, ids = "com.provider:+:8090")

public class ProductClientTest {

	@Autowired
	private ProductServiceConsumer productClient;

	public void testGetAllProducts() {
		List<Product> products = productClient.getAllProducts();
		assertEquals(2, productClient.getAllProducts());
		assertEquals("Product 1", products.get(0).getName());
		assertEquals("Product 2", products.get(1).getName());
	}
}
