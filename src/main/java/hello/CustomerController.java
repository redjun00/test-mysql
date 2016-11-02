package hello;

import hello.config.DatabaseConfig;
import hello.repository.CustomerRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;


@Configuration
@ComponentScan
public class CustomerController {

    public static void main(String[] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);//왜 DatabaseConfig
        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

    }
}
