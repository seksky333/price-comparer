package xyz.seksky.productcomparer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PriceComparerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceComparerApplication.class, args);
        System.out.println("Price Comparer is running!");
    }

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
						.allowedOrigins("*");

            }
        };
    }
}
