package lexian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Shop_Provider {
    public static void main(String[] args) {
        SpringApplication.run(Shop_Provider.class,args);
    }
}
