package lexian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class lexian_Zuul {
    public static void main(String[] args) {
        SpringApplication.run(lexian_Zuul.class,args);
    }
}
