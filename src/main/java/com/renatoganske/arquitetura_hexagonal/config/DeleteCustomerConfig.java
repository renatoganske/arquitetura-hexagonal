package com.renatoganske.arquitetura_hexagonal.config;

import com.renatoganske.arquitetura_hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.renatoganske.arquitetura_hexagonal.application.core.usecases.DeleteCustomerByIdUseCase;
import com.renatoganske.arquitetura_hexagonal.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                               DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase,
                deleteCustomerByIdAdapter);
    }
}