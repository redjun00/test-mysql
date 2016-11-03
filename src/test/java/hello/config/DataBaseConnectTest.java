package hello.config;

import hello.StoreApplication;
import hello.controller.CustomerController;
import hello.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StoreApplication.class)
public class DataBaseConnectTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    CustomerController customerController;

    @Before
    public void before(){
        assertNotNull(applicationContext);
        assertNotNull(customerController);
        assertEquals("fail at before test." , 0L, customerController.getCount());
    }

    @Test
    public void save_success(){

        Customer expectedCustomer = new Customer();
        expectedCustomer.setAddress("Seoul");
        expectedCustomer.setName("amy");

        customerController.putCustomer(expectedCustomer);
        assertEquals("fail to test." , 1L, customerController.getCount());
        customerController.printCount();
    }
}
