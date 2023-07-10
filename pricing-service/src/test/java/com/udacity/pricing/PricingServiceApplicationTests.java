package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

    @MockBean
    PricingService pricingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    // Make sure to run Eureka-Server, otherwise, you will get an error because the pricing microservice
    // is trying to connect to Eureka server which is not running!
    // However, such error will not affect the test case since it's not related to the connection to the server.
    // (The test case will pass anyway)
    @Test
    public void getPrices() throws Exception {
        mockMvc.perform(get("/services/price").param("vehicleId", "1"))
                .andExpect(status().isOk());
    }
}
