package com.provider;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.provider.OrderController;
import com.provider.OrderService;
import com.provider.ProviderApplication;

@SpringBootTest(classes = ProviderApplication.class)
public abstract class OrderBaseClass {
    @Autowired
    OrderController orderController;

    @MockBean
    OrderService orderService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(orderController);

        Mockito.when(orderService.getOrder("1"))
                .thenReturn(OrderService.orders.get("1"));
    }
}
