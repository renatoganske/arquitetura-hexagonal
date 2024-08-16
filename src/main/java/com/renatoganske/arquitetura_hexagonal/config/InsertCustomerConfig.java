package com.renatoganske.arquitetura_hexagonal.config;

import com.renatoganske.arquitetura_hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.renatoganske.arquitetura_hexagonal.adapters.out.InsertCustomerAdapter;
import com.renatoganske.arquitetura_hexagonal.adapters.out.SendCpfValidationAdapter;
import com.renatoganske.arquitetura_hexagonal.application.core.usecases.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(
                findAddressByZipCodeAdapter,
                insertCustomerAdapter,
                sendCpfValidationAdapter
        );
    }

}