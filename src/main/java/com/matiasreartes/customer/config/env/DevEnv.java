package com.matiasreartes.customer.config.env;

import com.matiasreartes.customer.config.Environment;
import com.matiasreartes.customer.infrastructure.output.adapter.mysql.MySQLCustomerRepository;
import com.matiasreartes.customer.infrastructure.output.port.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevEnv implements Environment {

    @Bean
    @Override
    public CustomerRepository customerRepository() {
        return new MySQLCustomerRepository();
    }
}
