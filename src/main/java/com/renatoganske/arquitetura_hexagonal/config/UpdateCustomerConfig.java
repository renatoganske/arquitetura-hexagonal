package com.renatoganske.arquitetura_hexagonal.config;

import com.renatoganske.arquitetura_hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.renatoganske.arquitetura_hexagonal.adapters.out.UpdateCustomerAdapter;
import com.renatoganske.arquitetura_hexagonal.application.core.usecases.FindCustomerByIdUseCase;
import com.renatoganske.arquitetura_hexagonal.application.core.usecases.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,
                findAddressByZipCodeAdapter,
                updateCustomerAdapter);
    }
}
