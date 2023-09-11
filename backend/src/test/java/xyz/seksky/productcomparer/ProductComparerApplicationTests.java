package xyz.seksky.productcomparer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import xyz.seksky.productcomparer.network.responses.GetPriceResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductComparerApplicationTests {
    final String domain = "http://localhost";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void productsShouldReturnListOfProducts() {
        String expectedModel = "WTB4604SC-R";

        GetPriceResponse response = this.restTemplate.getForObject(domain +":"+ port + "/products",
                GetPriceResponse.class);

        ;
        assertThat(response.getProducts().get(0).productModel()).isEqualTo(expectedModel);

    }
}
