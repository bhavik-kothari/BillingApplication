package my.assignment.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by bkothari on 26/05/18.
 */
@SpringBootApplication
public class BillingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}
}
