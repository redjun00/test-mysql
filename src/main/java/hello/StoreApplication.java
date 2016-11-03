package hello;

import hello.controller.CustomerController;
import hello.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//http://www.pretechsol.com/2013/11/springdata-jpa-with-mysql-example.html#.WBnrkOiLSUk

@Configuration
@ComponentScan
@EnableJpaRepositories  //specify the base package containing your repository interfaces.
public class  StoreApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(StoreApplication.class);
        CustomerController customerController = context.getBean(CustomerController.class);
        customerController.printCount();

        Customer expectedCustomer = new Customer();
        expectedCustomer.setAddress("Seoul");
        expectedCustomer.setName("amy");

        customerController.putCustomer(expectedCustomer);
    }
}
