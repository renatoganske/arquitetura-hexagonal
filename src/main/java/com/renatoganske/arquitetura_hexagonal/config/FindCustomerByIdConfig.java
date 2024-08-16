package com.renatoganske.arquitetura_hexagonal.config;

import com.renatoganske.arquitetura_hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.renatoganske.arquitetura_hexagonal.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}